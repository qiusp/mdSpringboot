package com.example.mdspringboot.common.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @Author: qiusp
 * @Description:
 * @Date: 2023/4/4 16:16
 */
public class NullToZeroStringSerialize extends JsonSerializer{
    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(String.valueOf(0));
    }
}
