package lotto.validation;

import lotto.util.LottoConstants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {
    private static final Pattern NUMBER = Pattern.compile("[0-9]*$");
    private static final Pattern NUMBER_AND_COMMA = Pattern.compile("[0-9,]*[0-9]$");
    private static final String ERROR_PURCHASING_AMOUNT = "[ERROR] 1,000 ~ 100,000 사이의 숫자를 1,000 단위로 입력해 주세요.";
    private static final String ERROR_WINNING_NUMBERS = "[ERROR] 1 ~ 45 사이의 숫자, 6개를 정확하게 입력해 주세요. 예)1,2,3,4,5,6";
    private static final String ERROR_BONUS_NUMBER = "[ERROR] 1 ~ 45 사이의 숫자 중, 당첨 번호와 동일하지 않은 숫자 하나만 입력해 주세요.";

    IllegalArgumentException exception;

    public boolean validatePurchasingAmount(String purchasingAmount) {
        exception = new IllegalArgumentException(ERROR_PURCHASING_AMOUNT);

        if (!checkNumberOnly(purchasingAmount)) {
            throw exception;
        }
        if (!checkNumberInThreeFigures(purchasingAmount)) {
            throw exception;
        }
        if (!checkLimitAmount(purchasingAmount)) {
            throw exception;
        }
        return true;
    }

    public boolean validateWinningNumber(String winningNumbers) {
        exception = new IllegalArgumentException(ERROR_WINNING_NUMBERS);

        if (!checkNumberAndComa(winningNumbers)) {
            throw exception;
        }
        if (!checkLimitLottoNumber(winningNumbers)) {
            throw exception;
        }
        if (!checkDuplicateNumber(winningNumbers)) {
            throw exception;
        }
        return true;
    }

    public boolean validateBonusNumber(List<Integer> winningNumbers, String bonusNumber) {
        exception = new IllegalArgumentException(ERROR_BONUS_NUMBER);

        if (!checkDuplicateWithWinningNumber(winningNumbers, bonusNumber)) {
            throw exception;
        }
        if (!checkLimitLottoNumber(bonusNumber)) {
            throw exception;
        }

        return true;
    }

    private boolean checkDuplicateWithWinningNumber(List<Integer> winningNumbers, String bonusNumber) {
        int number = Integer.parseInt(bonusNumber);

        if (winningNumbers.contains(number)) {
            return false;
        }
        return true;
    }
    private boolean checkDuplicateNumber(String readNumbers) {
        String[] readNumber = readNumbers.split(LottoConstants.DIVISION_STANDARD);
        List<String> numbers = Arrays.asList(readNumber);
        Collections.sort(numbers);
        boolean flag = true;

        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                flag = false;
                break;
            }
        }
        return flag;
    }
    private boolean checkLimitLottoNumber(String readNumbers) {
        String[] numbers = readNumbers.split(LottoConstants.DIVISION_STANDARD);
        boolean flag = true;

        for (String number : numbers) {
            int num = Integer.parseInt(number);

            if (num < LottoConstants.LOTTO_NUMBER_MIN || num > LottoConstants.LOTTO_NUMBER_MAX) {
                flag = false;
                break;
            }
        }

        return flag;
    }
    private boolean checkNumberAndComa(String readNumbers) {
        Matcher matcher = NUMBER_AND_COMMA.matcher(readNumbers);

        if (matcher.matches()) {
            return true;
        }
        return false;
    }
    private boolean checkNumberOnly(String readNumber) {
        Matcher matcher = NUMBER.matcher(readNumber);

        if (matcher.matches()) {
            return true;
        }
        return false;
    }
    private boolean checkLimitAmount(String readNumber) {
        int number = Integer.parseInt(readNumber);

        if (number >= LottoConstants.PURCHASE_LIMIT_MIN && number <= LottoConstants.PURCHASE_LIMIT_MAX) {
            return true;
        }
        return false;
    }
    private boolean checkNumberInThreeFigures(String readNumber) {
        int number = Integer.parseInt(readNumber);

        if (number % LottoConstants.LOTTO_MONEY_UNIT != 0) {
            return false;
        }
        return true;
    }
}
