package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.model.exceptions.NotCorrectInputException;
import lotto.model.exceptions.NotIntegerException;

public class StringToIntegerConvertor {
    // 정수 검증
    public static List<Integer> stringToInteger(List<String> input) {
        List<Integer> integerNumbers = new ArrayList<>();
        input.forEach(number -> {
            try {
                integerNumbers.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                throw new NotCorrectInputException();
            }
        });
        return integerNumbers;
    }

    // 보너스 번호 정수 검증
    public static int stringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NotIntegerException();
        }
    }
}