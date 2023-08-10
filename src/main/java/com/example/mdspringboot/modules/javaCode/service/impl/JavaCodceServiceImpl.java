package com.example.mdspringboot.modules.javaCode.service.impl;

import com.example.mdspringboot.modules.javaCode.service.IJavaCodeService;
import com.google.common.io.Files;
import org.springframework.stereotype.Service;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collections;
import java.util.Map;

/**
 * @Author: Administrator
 * @Description:
 * @Date: 2023/7/7 13:50
 */
@Service
public class JavaCodceServiceImpl implements IJavaCodeService {

    @Override
    public String tryJavaMap(Map<String, String> map) {
        try {
            // 创建临时文件
            File tempFile = new File(System.getProperty("java.io.tmpdir"), "test.java");
            // 将前端传入的代码写入临时文件
            writeToFile(map.get("code"), tempFile);
            // 编译代码
            compileCode(tempFile);
            // 执行代码
            return executeCompiledCode();
        } catch (Exception e) {
            return "Error executing code: " + e.getMessage();
        }
    }

    private void writeToFile(String code, File file) throws IOException {
        // 创建字符缓冲流 写入字符型数据
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            // 写入数据
            writer.write(code);
        }
    }

    private void compileCode(File file) throws IOException {
        try {
            // 获取编译器
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            // 获取文件管理器
            StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
            // 创建编译任务
            Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, null, null, compilationUnits);
            // 执行编译
            if (task.call()) {
                fileManager.close();
            }else {
                throw new IllegalStateException();
            }
        }catch (Exception e){
             System.out.println(e.getMessage());
        }
    }

    private String executeCompiledCode() throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, java.lang.reflect.InvocationTargetException {
        // 获取类加载器
        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{new File(System.getProperty("java.io.tmpdir")).toURI().toURL()});
        // 加载类
        Class<?> compiledClass = classLoader.loadClass("test");
        // 执行 main 方法
        Method mainMethod = compiledClass.getMethod("main", String[].class);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);
        try {
            // 执行方法
            mainMethod.invoke(null, new Object[]{new String[0]});
            // 刷新系统输出流
            System.out.flush();
            // 返回响应对象流
            return outputStream.toString();
        } finally {
            System.setOut(originalOut);
        }
    }

}
