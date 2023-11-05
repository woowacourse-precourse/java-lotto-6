package lotto;

import java.util.List;

public class TypeChanger {
    public static List<String> stringToList(String s) {
        List<String> userNumber = List.of(s.split(","));
        return userNumber;
    }
}
