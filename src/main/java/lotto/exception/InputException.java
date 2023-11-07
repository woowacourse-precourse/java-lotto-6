package lotto.exception;

import lotto.util.Converter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputException {
    public static void isValid(String input) {
        try {
            int amount = Integer.parseInt(input);
            isDivisionOk(amount);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(e.getMessage());
        }
    }

    private static void isDivisionOk(int input) {
        if (input % 1000 != 0) {
            throw new NumberFormatException("1000 단위의 숫자여야 합니다.");
        }
    }

    public static void isWinningNumberValid(String input) {
        try {
            List<Integer> winningNumber = Converter.stringToIntList(input);
            checkDuplicates(winningNumber);
            checkNumberLength(winningNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private static void checkNumberLength(List<Integer> winningNumber) {
        if (winningNumber.size() != 6) {
            throw new IllegalArgumentException("6개의 숫자를 ,기준으로 공백 없이 입력해주세요.");
        }
    }

    private static void checkDuplicates(List<Integer> winningNumber) {
        Set<Integer> checkDuplicateNumber = new HashSet<>(winningNumber);
        if (winningNumber.size() != checkDuplicateNumber.size()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    public static void isBounusNumberValid(String input) {
        try {
            isBonusNumberOne(input);
            int bonusNumber = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private static void isBonusNumberOne(String input) {
        if (input.length() != 1) {
            throw new NumberFormatException("한자리 자연수를 입력해야 합니다.");
        }
    }
}
