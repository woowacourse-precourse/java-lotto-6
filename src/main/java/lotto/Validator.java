package lotto;

import java.util.List;

public class Validator {

    public static void checkNumber(String userInput) {

        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 숫자만(양수) 입력해주세요.");
        }
    }

    public static void checkRemainder(Integer userInput) {
        if ((userInput % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 1000단위의 숫자를 입력해주세요.");
        }
    }

    public static void checkZero(String userInput) {
        if (userInput.charAt(0) == '0') {
            throw new IllegalArgumentException("[ERROR] 숫자 앞에 0을 입력하지 마세요.");
        }
    }


    public static void checkPositiveNumber(Integer number) {
        if (number <= 0) {
            throw new IllegalArgumentException("[ERROR] 양수를 입력해주세요.");
        }
    }
}
