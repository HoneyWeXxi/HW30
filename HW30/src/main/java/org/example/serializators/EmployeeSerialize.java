package org.example.serializators;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.example.Employee;

import java.lang.reflect.Type;

public class EmployeeSerialize implements JsonSerializer<Employee> {
    @Override
    public JsonElement serialize(Employee employee, Type type, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        result.addProperty("name", employee.getEmployeeName());
        result.addProperty("position", employee.getPosition());
        result.add("cases", context.serialize(employee.getCases()));
        return result;
    }
}
