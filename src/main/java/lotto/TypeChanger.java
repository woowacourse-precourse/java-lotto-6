package lotto;

import java.util.List;

public class TypeChanger {
    public static List<String> stringToListWithComma(String numbers) {
        List<String> userNumber = List.of(numbers.split(","));
        return userNumber;
    }
}
