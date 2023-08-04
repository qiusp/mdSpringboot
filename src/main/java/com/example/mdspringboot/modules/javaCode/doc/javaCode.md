参数：

    {
    "code": "public class TestJavaCode {\n    public static void main(String[] args){\n        System.out.println(\"你好\");\n    }\n}"
    }

问题：
[【报错描述】](https://blog.csdn.net/gongxifacai_believe/article/details/121729882)
warning: Can’t initialize javac processor due to (most likely) a class loader problem: java.lang.NoClassDefFoundError: com/sun/tools/javac/processing/JavacProcessingEnvironment


请求：
    
    {
        "code": "public class test {\n    public static void main(String[] args){\n        System.out.println(\"我是你爸爸\");\n    }\n}"
    }


    {
    "code": "import java.util.HashMap;\nimport java.util.Map;\n\n/**\n * @Author: Administrator\n * @Description:\n * @Date: 2023/8/3 20:03\n */\npublic class test {\n    public static void main(String[] args){\n        Map<Integer, String> map = new HashMap<>();\n        map.put(1,\"one\");\n        map.put(2,\"two\");\n        map.put(3,\"three\");\n        for(Integer num : map.keySet()){\n            System.out.println(map.get(num));\n        }\n    }\n}"
    }


