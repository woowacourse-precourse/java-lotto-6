package lotto.view;

import static lotto.view.constant.ViewConstant.InputViewConstant.COMMA;
import static lotto.view.constant.ViewConstant.InputViewConstant.MAX_RANGE;
import static lotto.view.constant.ViewConstant.InputViewConstant.MIN_RANGE;
import static lotto.view.constant.ViewConstant.InputViewConstant.NUMBERS_COUNT;
import static lotto.view.constant.ViewConstant.InputViewConstant.NUMBERS_FORMAT_REGEX;
import static lotto.view.constant.ViewConstant.InputViewConstant.NUMBER_REGEX;
import static lotto.view.constant.ViewConstant.InputViewConstant.ONE_LOTTO_PRICE;
import static lotto.view.constant.ViewConstant.InputViewConstant.ZERO;
import static lotto.view.constant.ViewConstant.InputViewConstant.InputErrorMessage.DUPLICATED_BONUS_NUMBER;
import static lotto.view.constant.ViewConstant.InputViewConstant.InputErrorMessage.NOT_CONTAINS_ONLY_NUMBER;
import static lotto.view.constant.ViewConstant.InputViewConstant.InputErrorMessage.NOT_EXIST_INPUT_ERROR;
import static lotto.view.constant.ViewConstant.InputViewConstant.InputErrorMessage.NOT_NUMBER;
import static lotto.view.constant.ViewConstant.InputViewConstant.InputErrorMessage.NOT_SIX_NUMBERS;
import static lotto.view.constant.ViewConstant.InputViewConstant.InputErrorMessage.NOT_THOUSAND_UNIT;
import static lotto.view.constant.ViewConstant.InputViewConstant.InputErrorMessage.OVER_RANGE;
import static lotto.view.constant.ViewConstant.InputViewConstant.InputErrorMessage.UNDER_THOUSAND_AMOUNT;
import static lotto.view.constant.ViewConstant.InputViewConstant.InputErrorMessage.WINNING_NUMBERS_INVALID_FORMAT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public long receivePurchaseAmount() {
        String purchaseAmount = Console.readLine();
        validatePurchaseAmount(purchaseAmount);
        return Long.parseLong(purchaseAmount);
    }

    private void validatePurchaseAmount(String purchaseAmount) {
        if (purchaseAmount.isBlank()) {
            throw new IllegalArgumentException(NOT_EXIST_INPUT_ERROR.getErrorMessage());
        }
        if (isNotContainsOnlyNumber(purchaseAmount)) {
            throw new IllegalArgumentException(NOT_CONTAINS_ONLY_NUMBER.getErrorMessage());
        }
        long amount = Long.parseLong(purchaseAmount);
        if (amount < ONE_LOTTO_PRICE) {
            throw new IllegalArgumentException(UNDER_THOUSAND_AMOUNT.getErrorMessage());
        }
        if (amount % ONE_LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(NOT_THOUSAND_UNIT.getErrorMessage());
        }
    }

    private boolean isNotContainsOnlyNumber(String purchaseAmount) {
        return !purchaseAmount.matches(NUMBER_REGEX);
    }

    public String receiveWinningNumber() {
        String winningNumber = Console.readLine();
        validateWinningNumber(winningNumber);
        return winningNumber;
    }

    private void validateWinningNumber(String winningNumber) {
        if (winningNumber.isBlank()) {
            throw new IllegalArgumentException(NOT_EXIST_INPUT_ERROR.getErrorMessage());
        }
        if (isInvalidNumbersFormat(winningNumber)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_INVALID_FORMAT.getErrorMessage());
        }
        if (hasNotSixNumbers(winningNumber)) {
            throw new IllegalArgumentException(NOT_SIX_NUMBERS.getErrorMessage());
        }
        validateEachNumber(winningNumber);
    }

    private boolean hasNotSixNumbers(String winningNumber) {
        return winningNumber.split(COMMA).length != NUMBERS_COUNT;
    }

    private boolean isInvalidNumbersFormat(String winningNumber) {
        return !winningNumber.matches(NUMBERS_FORMAT_REGEX);
    }

    private void validateEachNumber(String winningNumber) {
        List<String> numbers = Arrays.asList(winningNumber.split(COMMA));
        try {
            numbers.forEach(this::validateLottoNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public int receiveBonusNumber(String winningNumber) {
        String bonusNumber = Console.readLine();
        validateBonusNumber(winningNumber, bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    private void validateBonusNumber(String winningNumber, String bonusNumber) {
        if (bonusNumber.isBlank()) {
            throw new IllegalArgumentException(NOT_EXIST_INPUT_ERROR.getErrorMessage());
        }
        validateLottoNumber(bonusNumber);
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER.getErrorMessage());
        }
    }

    private void validateLottoNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.getErrorMessage());
        }

        int bonusNumberInt = Integer.parseInt(number);
        if (bonusNumberInt < MIN_RANGE || bonusNumberInt > MAX_RANGE) {
            throw new IllegalArgumentException(OVER_RANGE.getErrorMessage());
        }
    }
}
