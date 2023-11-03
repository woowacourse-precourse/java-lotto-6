package lotto;

import camp.nextstep.edu.missionutils.Console;

import static lotto.ErrorMessage.*;

public class UserInputHandler {

    private static final String INPUT_USER_LOTTO_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_USER_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_USER_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final int DIVISION_ROLE = 1000; // 나누어 떨어져야 하는 값 : 1,000원 단위

    // 로또 구매 금액 입력
    public void inputUserLottoPurchase() {
        boolean restart = true;

        while (restart) {
            try {
                System.out.println(INPUT_USER_LOTTO_PURCHASE_MESSAGE);
                String lottoPurchase = Console.readLine();
                validUserLottoPurchase(lottoPurchase);
                restart = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 1000원단위, 1000원 미만, 숫자 이외의 값 확인
    private void validUserLottoPurchase(String lottoPurchase) {
        try {
            int lottoPurchaseValue = Integer.parseInt(lottoPurchase);
            if (lottoPurchaseValue % DIVISION_ROLE != 0) {
                throw new IllegalArgumentException(LOTTO_PURCHASE_FORMAT_ERROR.getMessage());
            } else if (lottoPurchaseValue < DIVISION_ROLE) {
                throw new IllegalArgumentException(LOTTO_PURCHASE_MIN_ERROR.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_INPUT.getMessage());
        }
    }

    // 로또 당첨 번호 입력
    public void inputUserWinningNumbers() {
        boolean restart = true;

        while (restart) {
            try {
                System.out.println(INPUT_USER_WINNING_NUMBERS_MESSAGE);
                String winningNumbers = Console.readLine();
                validateUserWinningNumbers(winningNumbers);
                restart = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private void validateUserWinningNumbers(String winningNumbers) {
        String[] numbers = winningNumbers.split(",");
        validateNumbers(numbers);
        if (numbers.length != 6) {
            throw new IllegalArgumentException(WINNING_NUMBERS_COUNT_ERROR.getMessage());
        }
    }

    // 숫자가 아닌 경우 (여러 개의 값 - 6개)
    private void validateNumbers(String[] numbers) {
        for (String str : numbers) {
            try {
                isOverLengthNumber(Integer.parseInt(str));
            } catch (NumberFormatException e) {
                throw new NumberFormatException(NON_NUMERIC_INPUT.getMessage());
            }
        }
    }

    // 숫자가 아닌 경우 (단일 값 - 보너스 번호)
    private void validateNumbers(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NON_NUMERIC_INPUT.getMessage());
        }
    }

    // 1 ~ 45 사이의 수 확인
    private void isOverLengthNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(NUMBERS_OUT_OF_RANGE.getMessage());
        }
    }

    // 보너스 번호 입력
    public void inputUserBonusNumber() {
        boolean restart = true;

        while (restart) {
            System.out.println(INPUT_USER_BONUS_NUMBER_MESSAGE);
            String bonusNumber = Console.readLine();
            try {
                validateNumbers(bonusNumber);
                isOverLengthNumber(Integer.parseInt(bonusNumber));
                restart = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}