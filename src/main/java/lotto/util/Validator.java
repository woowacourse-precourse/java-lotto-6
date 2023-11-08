package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Validator {
    public static void validateLottoPurchaseAmount(String input) {
        validateIsInteger(input);
        validateIsDivide(Integer.parseInt(input));
    }

    private static void validateIsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            String message = ExceptionMessage.WIN_LOTTO_INTEGER.getMessage();
            throw new IllegalArgumentException(message);
        }
    }

    private static void validateIsDivide(int input) {
        if (input % Constant.AMOUNT_ONE_LOTTO != 0) {
            String message = ExceptionMessage.LOTTO_PURCHASE_AMOUNT_DIVIDE.getMessage();
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateWinLotto(String input) {
        validateWinLottoSplitUnit(input);
        validateWinLottoNumber(input);
        validateWinLottoOverlap(input);
        validateWinLottoNumbersInteger(input);
    }

    public static void validateWinBonus(String input, List<Integer> lottoInput) {
        validateWinBonusNumber(input);
        validateWinLottoNumbersInteger(input);
    }

    private static void validateWinLottoSplitUnit(String input) {
        String[] lottoResult;

        try {
            lottoResult = input.split(Constant.SPLIT_UNIT);
        } catch (IllegalArgumentException e) {
            String message = ExceptionMessage.WIN_LOTTO_SPLIT_UNIT.getMessage();
            throw new IllegalArgumentException(message);
        }
    }

    private static void validateWinLottoNumber(String input) {
        String[] lottoResult = input.split(Constant.SPLIT_UNIT);

        if (lottoResult.length != 6) {
            String message = ExceptionMessage.WIN_LOTTO_NUMBER.getMessage();
            throw new IllegalArgumentException(message);
        }
    }

    private static void validateWinBonusNumber(String input) {
        if (input.length() != 1) {
            String message = ExceptionMessage.WIN_LOTTO_NUMBER.getMessage();
            throw new IllegalArgumentException(message);
        }
    }

    private static void validateWinLottoOverlap(String input) {
        String[] lottoResult = input.split(Constant.SPLIT_UNIT);
        List<String> list = Arrays.stream(lottoResult).toList();

        if (list.size() != list.stream().distinct().count()) {
            String message = ExceptionMessage.WIN_LOTTO_OVERLAP.getMessage();
            throw new IllegalArgumentException(message);
        }
    }

    private static void validateWinLottoNumbersInteger(String input) {
        String[] lottoResult = input.split(Constant.SPLIT_UNIT);
        String strLottoResult = String.join("", lottoResult);

        try {
            Integer.parseInt(strLottoResult);
        } catch (IllegalArgumentException e) {
            String message = ExceptionMessage.WIN_LOTTO_INTEGER.getMessage();
            throw new IllegalArgumentException(message);
        }
    }
}
