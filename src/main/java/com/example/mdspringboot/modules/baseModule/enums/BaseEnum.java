package com.example.mdspringboot.modules.baseModule.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: qiusp
 * @Description:   
 * @Date: 2023/2/14 15:58
 */
@Getter
@AllArgsConstructor
public enum BaseEnum {
    ELECTIONS(1, "选任"),
    CHANGE_OF_TERM(2, "换届"),
    ;
    
    final Integer key;
    final String value;

    public static String getValueByKey(Integer key) {
        for (BaseEnum facultyIsSelectEnum : BaseEnum.values()) {
            if (facultyIsSelectEnum.key.equals(key)) {
                return facultyIsSelectEnum.getValue();
            }
        }
        return null;
    }
}
