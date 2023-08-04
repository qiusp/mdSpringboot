package com.example.mdspringboot.modules.javaCode.controller;

import com.example.mdspringboot.modules.javaCode.service.IJavaCodeService;
import com.example.mdspringboot.modules.r.R;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * @Author: qiusp
 * @Description:
 * @Date: 2023/8/3 16:33
 */

@RestController
@AllArgsConstructor
@RequestMapping("/javacode")
@Api(value = "javacode", tags = "javacode")
public class JavaCodeController {

    @Autowired
    IJavaCodeService javaCodeService;

    // @GetMapping("/tryJava")
    // @ApiOperationSupport(order = 1)
    // @ApiOperation(value = "测试")
    // public R<String> tryJava(@ApiParam(value = "code") @RequestParam String code) {
    //     return R.data(javaCodeService.tryJava(code));
    // }

    @PostMapping("/tryJavaMap")
    @ApiOperationSupport(order = 2)
    @ApiOperation(value = "OK")
    public R<String> tryJavaMap(@RequestBody Map<String, String> map) {
        String code = map.get("code");
        // return R.data(javaCodeService.tryJava(code));
        return R.data(javaCodeService.tryJavaMap(map));
    }

}
