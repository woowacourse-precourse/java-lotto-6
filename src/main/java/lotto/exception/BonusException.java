package lotto.exception;

import lotto.controller.MessageManager;

import java.util.List;

public class BonusException {
    public void isItNumber(String readLine) {
        try {
            Integer.parseInt(readLine);
        } catch (IllegalArgumentException e) {
            System.out.println(MessageManager.ERROR_IS_NOT_NUMBER);
            throw new IllegalArgumentException();
        }
    }

    public void isItCheckedRange(String readline) {
        int number = Integer.parseInt(readline);
        if (number < MessageManager.LOTTO_MIN || number > MessageManager.LOTTO_MAX) {
            System.out.println(MessageManager.ERROR_OUT_OF_RANGE);
            throw new IllegalArgumentException();
        }
    }

    public void isItContainSameNumber(String readLine, List<Integer> winningNumber) {
        if (winningNumber.contains(Integer.parseInt(readLine))) {
            System.out.println(MessageManager.ERROR_IS_ALREADY_CONTAIN);
            throw new IllegalArgumentException();
        }
    }
}
