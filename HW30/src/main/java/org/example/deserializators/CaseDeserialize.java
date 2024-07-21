package org.example.deserializators;

import com.google.gson.*;
import org.example.Case;

import java.lang.reflect.Type;

public class CaseDeserialize implements JsonDeserializer<Case> {
    @Override
    public Case deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Case c = new Case();
        String data = jsonElement.getAsString();
        String caseTitle = data.substring(0, data.indexOf(":"));
        String caseDescription = data.substring(data.indexOf(":") + 1);
        c.setCaseTitle(caseTitle);
        c.setDescription(caseDescription);
        return c;
    }
}
