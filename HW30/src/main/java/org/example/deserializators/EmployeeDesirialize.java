package org.example.deserializators;

import com.google.gson.*;
import org.example.Case;
import org.example.Employee;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDesirialize implements JsonDeserializer<Employee> {
    @Override
    public Employee deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject employeeJson = jsonElement.getAsJsonObject();
        Employee employee = new Employee();
        employee.setEmployeeName(employeeJson.get("name").getAsString());
        employee.setPosition(employeeJson.get("position").getAsString());
        List<Case> cases = new ArrayList<>();
        JsonArray caseArray = employeeJson.get("cases").getAsJsonArray();
        for (JsonElement jsonCase : caseArray) {
            cases.add(context.deserialize(jsonCase, Case.class));
        }
        employee.setCases(cases);
        return employee;
    }
}
