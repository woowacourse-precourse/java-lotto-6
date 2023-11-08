package lotto.util;

public class ValidateWinningNumber {

    private static void isSixNumber(String inputValue) {

        String[] winningNumberStringArray = inputValue.split(",");

        if (winningNumberStringArray.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        }

    }

}
