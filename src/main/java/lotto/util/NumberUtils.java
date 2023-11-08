package lotto.util;

import lotto.view.InputView;

public class NumberUtils {

    private NumberUtils() {

    }

    public static int checkNumber(String input) {
        int inputNumber = 0;

        try {
            inputNumber = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 숫자만 입력 가능합니다. 다시 입력해주세요.");
            InputView.getInputNumber();
        }

        return inputNumber;
    }
}
