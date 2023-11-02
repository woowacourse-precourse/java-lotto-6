package lotto.utility;

import java.util.List;

public class Utility {
    public int getNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다");
        }
    }

    public String[] splitInput (String input) {
        String[] numbers = input.split(",");

        return numbers;
    }
}
