package lotto.exception;

import lotto.controller.MessageManager;

import java.util.Arrays;

public class WinningException {
    public void isItCountOfNumber(String readline) {
        String[] numbers = readline.split(",");
        if (numbers.length != 6) {
            System.out.println(MessageManager.ERROR_IS_NOT_CORRECT_SIZE);
            throw new IllegalArgumentException();
        }
    }

    public void isItContainSameNumber(String readLine) {
        String[] numbers = readLine.split(",");
        if (numbers.length != Arrays.stream(numbers).distinct().count()) {
            System.out.println(MessageManager.ERROR_IS_ALREADY_CONTAIN);
            throw new IllegalArgumentException();
        }
    }

    public void isItCheckedRange(String readLine) {
        String[] numbers = readLine.split(",");
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (num < MessageManager.LOTTO_MIN || num > MessageManager.LOTTO_MAX) {
                System.out.println(MessageManager.ERROR_OUT_OF_RANGE);
                throw new IllegalArgumentException();
            }
        }
    }
}
