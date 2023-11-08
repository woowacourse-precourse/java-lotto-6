package lotto.service;

import java.util.List;

public class WinningNumbersValidator {
    public static void isNothingWinningNumber(List<String> winningNumbers) {
        if (winningNumbers.isEmpty()) {
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE + Constant.NOTHING_WAS_ENTERED);
        }
    }

    public static void isRightFormat(List<String> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE + Constant.WRONG_FORMAT);
        }
    }

    public static void isDigitInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            char target = input.charAt(i);
            if (target == ' ') {
                throw new IllegalArgumentException(Constant.ERROR_MESSAGE + Constant.EXIST_BLANK);
            }
            if (!Character.isDigit(target)) {
                throw new IllegalArgumentException(Constant.ERROR_MESSAGE + Constant.INPUT_IS_NOT_NUMBER);
            }
        }
    }

    public static void isDigitWinningNumber(List<String> winningNumbers) {
        for (int i = 0; i < 6; i++) {
            isDigitInput(winningNumbers.get(i));
        }
    }

    public static void isIncludeEmpty(List<String> winningNumbers) {
        for (int i = 0; i < 6; i++) {
            if (winningNumbers.get(i).equals("")) {
                throw new IllegalArgumentException(Constant.ERROR_MESSAGE + Constant.MISSING_NUMBER);
            }
        }
    }

    public static void isRightNumber(List<String> winningNumbers) {
        for (int i = 0; i < 6; i++) {
            int target = Integer.parseInt(winningNumbers.get(i));
            if (target < 1 || target > 45) {
                throw new IllegalArgumentException(Constant.ERROR_MESSAGE + Constant.WRONG_NUMBER);
            }
        }
    }

    public static void isDuplicated(List<String> winningNumbers) {
        if (winningNumbers.size() != winningNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE + Constant.DUPLICATED_NUMBER);
        }
    }

    public boolean checkWinningNumber(List<String> winningNumber) {
        boolean check = true;
        try {
            isNothingWinningNumber(winningNumber);
            isRightFormat(winningNumber);
            isDigitWinningNumber(winningNumber);
            isIncludeEmpty(winningNumber);
            isRightNumber(winningNumber);
            isDuplicated(winningNumber);
        } catch (IllegalArgumentException e) {
            check = false;
            System.out.println(e.getMessage());
        }
        return check;
    }

    public static void isNothingInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE + Constant.NOTHING_WAS_ENTERED);
        }
    }

    public static void isRightBonusNumber(String input) {
        int target = Integer.parseInt(input);
        if (target < 1 || target > 45) {
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE + Constant.WRONG_NUMBER);
        }
    }

    public static void isDuplicatedBonusNumber(String input, List<String> numbers) {
        if (numbers.contains(input)) {
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE + Constant.ALREADY_EXTRACTED);
        }
    }

    public boolean checkBonusNumber(String input, List<String> numbers) {
        boolean check = true;
        try {
            isNothingInput(input);
            isDigitInput(input);
            isRightBonusNumber(input);
            isDuplicatedBonusNumber(input, numbers);
        } catch (IllegalArgumentException e) {
            check = false;
            System.out.println(e.getMessage());
        }
        return check;
    }
}
