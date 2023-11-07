package lotto.utils;

import java.util.ArrayList;
import java.util.List;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoConfig;

public class InputValidator {
    public static void checkLottoPayAmountInput(String lottoPayAmount) {
        checkNoInput(lottoPayAmount);
        checkNumeric(lottoPayAmount);
        checkLessAmount(lottoPayAmount);
        checkLessAmountUnit(lottoPayAmount);
    }

    private static void checkLessAmountUnit(String lottoPayAmount) {
        if (Integer.parseInt(lottoPayAmount) % LottoConfig.LOTTO_AMOUNT.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.LESS_AMOUNT_UNIT_ERROR.getErrorMessage());
        }
    }

    private static void checkLessAmount(String lottoPayAmount) {
        if (Integer.parseInt(lottoPayAmount) < LottoConfig.LOTTO_AMOUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.LESS_AMOUNT_ERROR.getErrorMessage());
        }
    }

    private static void checkNumeric(String lottoPayAmount) {
        try {
            Integer.parseInt(lottoPayAmount);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.NUMERIC_ERROR.getErrorMessage());
        }
    }

    public static void checkJackpotNumberInput(String jackpotNumberInput) {
        checkNoInput(jackpotNumberInput);
        checkHasComma(jackpotNumberInput);
        checkContainSpace(jackpotNumberInput);
        checkJackpotNumberNumeric(jackpotNumberInput);
        checkJackpotNumberSize(jackpotNumberInput);
        checkEndsWithComma(jackpotNumberInput);
        checkNumberOfRange(jackpotNumberInput);
        checkDuplicateNumberInJackpotNumbers(jackpotNumberInput);
    }

    private static void checkDuplicateNumberInJackpotNumbers(String jackpotNumberInput) {
        List<Integer> setNumbers = new ArrayList<>();
        String[] splitNumbers = jackpotNumberInput.split(",");
        for (int i = 0; i < splitNumbers.length; i++) {
            int nowNumber = Integer.parseInt(splitNumbers[i]);
            if (setNumbers.contains(nowNumber)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_ERROR.getErrorMessage());
            }
            setNumbers.add(nowNumber);
        }
    }

    private static void checkNoInput(String jackpotNumberInput) {
        if (jackpotNumberInput.length() == 0) {
            throw new IllegalArgumentException(ErrorMessage.NO_INPUT_ERROR.getErrorMessage());
        }
    }

    private static void checkNumberOfRange(String numberInput) {
        String replaceNumberInput = numberInput.replace(",", "");
        for (int i = 0; i < replaceNumberInput.length(); i++) {
            int number = Integer.parseInt(String.valueOf(replaceNumberInput.charAt(i)));
            if (number < LottoConfig.LOTTO_MINIMUM_NUMBER.getValue()
                    || LottoConfig.LOTTO_MAXIMUM_NUMBER.getValue() < number) {
                throw new IllegalArgumentException(ErrorMessage.JACKPOT_NUMBER_OUT_OF_RANGE_ERROR.getErrorMessage());
            }
        }
    }

    private static void checkEndsWithComma(String jackpotNumberInput) {
        if (jackpotNumberInput.charAt(jackpotNumberInput.length() - 1) == ',') {
            throw new IllegalArgumentException(ErrorMessage.END_WITH_COMMA_ERROR.getErrorMessage());
        }
    }

    private static void checkJackpotNumberSize(String jackpotNumberInput) {
        String[] jackpotNumbers = jackpotNumberInput.split(",");
        if (jackpotNumbers.length != LottoConfig.LOTTO_NUMBER_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.JACKPOT_NUMBER_SIZE_ERROR.getErrorMessage());
        }
    }

    private static void checkJackpotNumberNumeric(String jackpotNumberInput) {
        String replaceNumberInput = jackpotNumberInput.replace(",", "");
        checkNumeric(replaceNumberInput);
    }

    private static void checkContainSpace(String jackpotNumberInput) {
        if (jackpotNumberInput.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.HAS_SPACE_ERROR.getErrorMessage());
        }
    }

    private static void checkHasComma(String jackpotNumberInput) {
        if (!jackpotNumberInput.contains(",")) {
            throw new IllegalArgumentException(ErrorMessage.HAS_NOT_COMMA_ERROR.getErrorMessage());
        }
    }

    public static void checkBonusNumberInput(String bonusNumberInput) {
        checkNoInput(bonusNumberInput);
        checkNumeric(bonusNumberInput);
        checkNumberOfRange(bonusNumberInput);
    }

    public static void checkDuplicateNumberInBonusNumbers(List<Integer> jackpotNumber, String bonusNumberInput) {
        for (int i = 0; i < jackpotNumber.size(); i++) {
            if (jackpotNumber.contains(Integer.parseInt(bonusNumberInput))) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_ERROR.getErrorMessage());
            }
        }
    }
}
