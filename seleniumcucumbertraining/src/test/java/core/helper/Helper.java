package core.helper;

import core.dataFaker.DataFaker;

import java.util.HashMap;
import java.util.Map;

public class Helper {
    static DataFaker dataFaker = new DataFaker();

    public static Map<String, String> createDataToFillFormWithOneFieldChanged(String field, String value) {
        Map<String, String> map = new HashMap<>();
        map.put("First Name", dataFaker.getFakeFirstName());
        map.put("Last Name", dataFaker.getFakeLastName());
        map.put("Email", dataFaker.getFakeEmail());
        map.put("Telephone", dataFaker.getFakeTelephone());
        map.put("Password", dataFaker.getFakePassword());
        map.put("Password Confirm", dataFaker.getFakePasswordConfirm());
        map.replace(field, value);
        return map;
    }

    public static Map<String, String> iFillInAllTheInputFieldsWithInvalid(String key) {
        Map<String, String> map = new HashMap<>();
        map.put("First Name", dataFaker.getFakeFirstName());
        map.put("Last Name", dataFaker.getFakeLastName());
        map.put("Email", dataFaker.getFakeEmail());
        map.put("Telephone", dataFaker.getFakeTelephone());
        map.put("Password", dataFaker.getFakePassword());
        map.put("Password Confirm", dataFaker.getFakePasswordConfirm());
        map.replace(key, "");
        return map;
    }
}