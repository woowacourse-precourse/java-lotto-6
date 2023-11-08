package lotto.util;

public class ValidateNumber {

    private static int isInteger(String inputValue) {

        if (!inputValue.matches("-?\\d+")){
            throw new IllegalArgumentException("[ERROR] 정수를 입력해주세요.");
        }

        return Integer.parseInt(inputValue);
    }

}
