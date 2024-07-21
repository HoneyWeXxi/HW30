package org.example.serializators;

import com.google.gson.*;
import org.example.Case;

import java.lang.reflect.Type;

public class CaseSerialize implements JsonSerializer<Case> {
    @Override
    public JsonElement serialize(Case aCase, Type type, JsonSerializationContext context) {
       JsonElement jsonObject = new JsonPrimitive(
               aCase.getCaseTitle() + ":" + aCase.getDescription()
       );
       return  jsonObject;
    }
}
