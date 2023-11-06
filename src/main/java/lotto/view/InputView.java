package lotto.view;

import static lotto.view.constant.ViewConstant.InputViewConstant.COMMA;
import static lotto.view.constant.ViewConstant.InputViewConstant.MAX_RANGE;
import static lotto.view.constant.ViewConstant.InputViewConstant.MIN_RANGE;
import static lotto.view.constant.ViewConstant.InputViewConstant.NUMBERS_COUNT;
import static lotto.view.constant.ViewConstant.InputViewConstant.NUMBERS_FORMAT_REGEX;
import static lotto.view.constant.ViewConstant.InputViewConstant.NUMBER_REGEX;
import static lotto.view.constant.ViewConstant.InputViewConstant.LOTTO_PRICE;
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
        final String purchaseAmount = Console.readLine();
        validatePurchaseAmount(purchaseAmount);
        return Long.parseLong(purchaseAmount);
    }

    private void validatePurchaseAmount(final String purchaseAmount) {
        if (purchaseAmount.isBlank()) {
            throw new IllegalArgumentException(NOT_EXIST_INPUT_ERROR.getErrorMessage());
        }
        if (isNotContainsOnlyNumber(purchaseAmount)) {
            throw new IllegalArgumentException(NOT_CONTAINS_ONLY_NUMBER.getErrorMessage());
        }
        final long amount = Long.parseLong(purchaseAmount);
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(UNDER_THOUSAND_AMOUNT.getErrorMessage());
        }
        if (amount % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(NOT_THOUSAND_UNIT.getErrorMessage());
        }
    }

    private boolean isNotContainsOnlyNumber(final String purchaseAmount) {
        return !purchaseAmount.matches(NUMBER_REGEX);
    }

    public String receiveWinningNumber() {
        final String winningNumber = Console.readLine();
        validateWinningNumber(winningNumber);
        return winningNumber;
    }

    private void validateWinningNumber(final String winningNumber) {
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

    private boolean hasNotSixNumbers(final String winningNumber) {
        return winningNumber.split(COMMA).length != NUMBERS_COUNT;
    }

    private boolean isInvalidNumbersFormat(final String winningNumber) {
        return !winningNumber.matches(NUMBERS_FORMAT_REGEX);
    }

    private void validateEachNumber(final String winningNumber) {
        final List<String> numbers = Arrays.asList(winningNumber.split(COMMA));
        try {
            numbers.forEach(this::validateLottoNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public int receiveBonusNumber(final String winningNumber) {
        final String bonusNumber = Console.readLine();
        validateBonusNumber(winningNumber, bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    private void validateBonusNumber(final String winningNumber, final String bonusNumber) {
        if (bonusNumber.isBlank()) {
            throw new IllegalArgumentException(NOT_EXIST_INPUT_ERROR.getErrorMessage());
        }
        validateLottoNumber(bonusNumber);
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER.getErrorMessage());
        }
    }

    private void validateLottoNumber(final String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.getErrorMessage());
        }

        final int parsedNumber = Integer.parseInt(number);
        if (parsedNumber < MIN_RANGE || parsedNumber > MAX_RANGE) {
            throw new IllegalArgumentException(OVER_RANGE.getErrorMessage());
        }
    }
}
