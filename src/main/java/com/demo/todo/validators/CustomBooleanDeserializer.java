package com.demo.todo.validators;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class CustomBooleanDeserializer extends JsonDeserializer<Boolean> {

    @Override
    public Boolean deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String value = p.getText().trim();

        if (!"true".equals(value) && !"false".equals(value)) {
            throw new JsonProcessingException("Invalid boolean value: " + value) {
            };
        }

        return Boolean.parseBoolean(value);
    }
}