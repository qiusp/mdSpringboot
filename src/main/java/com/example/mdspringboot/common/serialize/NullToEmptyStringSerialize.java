package com.example.mdspringboot.common.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Objects;

/**
 * @Author: qiusp
 * @Description: 序列化
 * @Date: 2023/6/30 15:44
 */
public class NullToEmptyStringSerialize extends JsonSerializer {
    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if ("null" == value || Objects.isNull(value)){
            gen.writeString("");
        }
    }
}
