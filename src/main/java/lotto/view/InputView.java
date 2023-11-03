package lotto.view;

import static lotto.view.InputView.InputErrorMessage.NOT_CONTAINS_ONLY_NUMBER;
import static lotto.view.InputView.InputErrorMessage.NOT_EXIST_INPUT_ERROR;
import static lotto.view.InputView.InputErrorMessage.NOT_NUMBER;
import static lotto.view.InputView.InputErrorMessage.OVER_RANGE;
import static lotto.view.InputView.InputErrorMessage.WINNING_NUMBERS_INVALID_FORMAT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String COMMA = ",";
    private static final String NUMBERS_FORMAT_REGEX = "([0-9]{1,2},?)+";
    private static final String NUMBER_REGEX = "[0-9]+";
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    public int receivePurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        String purchaseAmount = Console.readLine();
        validatePurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    private void validatePurchaseAmount(String purchaseAmount) {
        if (purchaseAmount.isBlank()) {
            throw new IllegalArgumentException(NOT_EXIST_INPUT_ERROR.getErrorMessage());
        }
        if (isNotContainsOnlyNumber(purchaseAmount)) {
            throw new IllegalArgumentException(NOT_CONTAINS_ONLY_NUMBER.getErrorMessage());
        }
    }

    private boolean isNotContainsOnlyNumber(String purchaseAmount) {
        return !purchaseAmount.matches(NUMBER_REGEX);
    }

    public String receiveWinningNumber() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        String winningNumber = Console.readLine();
        validateWinningNumber(winningNumber);
        System.out.println();
        return winningNumber;
    }

    private void validateWinningNumber(String winningNumber) {
        if (winningNumber.isBlank()) {
            throw new IllegalArgumentException(NOT_EXIST_INPUT_ERROR.getErrorMessage());
        }
        if (isInvalidNumbersFormat(winningNumber)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_INVALID_FORMAT.getErrorMessage());
        }

        List<String> numbers = Arrays.asList(winningNumber.split(COMMA));
        try {
            numbers.forEach(this::validateLottoNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private boolean isInvalidNumbersFormat(String winningNumber) {
        return !winningNumber.matches(NUMBERS_FORMAT_REGEX);
    }

    public int receiveBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        String bonusNumber = Console.readLine();
        validateLottoNumber(bonusNumber);
        System.out.println();
        return Integer.parseInt(bonusNumber);
    }

    private void validateLottoNumber(String number) {
        if (number.isBlank()) {
            throw new IllegalArgumentException(NOT_EXIST_INPUT_ERROR.getErrorMessage());
        }

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

    enum InputErrorMessage {
        NOT_EXIST_INPUT_ERROR("[ERROR] 입력이 존재하지 않습니다."),
        NOT_CONTAINS_ONLY_NUMBER("[ERROR] 숫자 이외의 문자는 포함될 수 없습니다."),
        WINNING_NUMBERS_INVALID_FORMAT("[ERROR] 입력 형식이 올바르지 않습니다."),
        NOT_NUMBER("[ERROR] 값은 숫자만 가능합니다."),
        OVER_RANGE("[ERROR] 숫자 범위는 1부터 45까지 가능합니다.");

        private final String errorMessage;

        InputErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }
}
