package org.ph0.civichack;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Provider
public class JacksonObjectMapperProvider implements ContextResolver<ObjectMapper> {
    public ObjectMapper getContext(final Class<?> type) {
        final ObjectMapper ret = new ObjectMapper();
        ret.disable(MapperFeature.USE_ANNOTATIONS);
        ret.enable(SerializationFeature.INDENT_OUTPUT);
        return ret;
    }
}