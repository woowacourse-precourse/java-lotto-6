package lotto.validator;

import lotto.constants.GameNumberConstants;
import java.util.List;

public class Validator {
    private static final String INPUT_IS_NOT_PRIME_NUMBER = "[ERROR] 입력이 정수가 아닙니다.";
    private static final String INPUT_IS_NOT_POSITIVE_NUMBER = "[ERROR] 입력이 양의 정수가 아닙니다.";
    private static final String INPUT_IS_NOT_IN_UNITS_OF_LOTTO_PRICE = "[ERROR] 입력이 %d원 단위가 아닙니다.";
    private static final String WINNING_NUMBER_FORM_IS_WRONG = "[ERROR] 당첨 번호의 형식이 잘 못 됐습니다.";

    private Validator() {
    }

    public static void validateWinningNumberForm(String winningNumber) {
        Validator.checkWinningNumberForm(winningNumber);
        Validator.areAllPrimeNumber(List.of(winningNumber.split(",")));
    }

    public static void validateBonusNumberForm(String bonusNumber) {
        Validator.isPrimeNumber(bonusNumber);
    }


    public static void areAllPrimeNumber(List<String> inputs) {
        inputs.stream().forEach(Validator::isPrimeNumber);
    }

    public static void isPrimeNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INPUT_IS_NOT_PRIME_NUMBER);
        }
    }

    public static void isPositiveNumber(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException(INPUT_IS_NOT_POSITIVE_NUMBER);
        }
    }

    public static void isUnitsOfLottoPrice(int input) {
        if (input % GameNumberConstants.LOTTO_PRICE.getValue() == 0) {
            return;
        }
        throw new IllegalArgumentException(String.format(
                INPUT_IS_NOT_IN_UNITS_OF_LOTTO_PRICE,
                GameNumberConstants.LOTTO_PRICE.getValue()));
    }

    public static void checkWinningNumberForm(String winningNumber) {
        String regularExpForInput = "[^,]+,(?:[^,]+,)*[^,]+";
        if (!winningNumber.matches(regularExpForInput)) {
            throw new IllegalArgumentException(WINNING_NUMBER_FORM_IS_WRONG);
        }
    }

}
