package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.jackson.modules.BeanIntrospectionModule;
import org.junit.jupiter.api.Test;

public class IntrospectedDeserializationTest {
  @Introspected
  public static final class Wrapper {
    final String value;

    public Wrapper(String value) {
      this.value = value;
    }
  }

  @Test
  public void deserializeViaReflection() throws Exception {
    ObjectMapper mapper = new ObjectMapper();

    mapper.readValue("\"good\"", Wrapper.class);
  }

  @Test
  public void deserializeViaBeanIntrospection() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new BeanIntrospectionModule());

    mapper.readValue("\"bad\"", Wrapper.class);
  }
}
