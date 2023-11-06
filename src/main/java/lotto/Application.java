package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    private static final String MESSAGE_FOR_PURCHASE_AMOUNT_INPUT = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_FOR_WINNING_NUMBERS_INPUT = "당첨 번호를 입력해 주세요.";

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final String ERROR_MESSAGE_FOR_PURCHASE_AMOUNT_INPUT = "구앱금액은 1000원 단위로 숫자를 입력해 주세요.";
    private static final String ERROR_MESSAGE_FOR_WINNING_NUMBER_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmountWithInput();
        List<Integer> winningNumbers = getWinningNumbersWithInput();
    }

    private static int getPurchaseAmountWithInput() {
        System.out.println(MESSAGE_FOR_PURCHASE_AMOUNT_INPUT);
        while (true) {
            String purchaseAmountInput = Console.readLine();
            try {
                validatePurchaseAmountInput(purchaseAmountInput);
            } catch (IllegalArgumentException e) {
                printErrorMessage(ERROR_MESSAGE_FOR_PURCHASE_AMOUNT_INPUT);
                continue;
            }
            return Integer.parseInt(purchaseAmountInput);
        }
    }

    private static void validatePurchaseAmountInput(String purchaseAmountInput) {
        try {
            int purchaseAmount = Integer.parseInt(purchaseAmountInput);
            if (purchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> getWinningNumbersWithInput() {
        System.out.println(MESSAGE_FOR_WINNING_NUMBERS_INPUT);
        while (true) {
            String winningNumbersInput = Console.readLine();
            try {
                validateWinningNumbersInput(winningNumbersInput);
            } catch (IllegalArgumentException e) {
                continue;
            }
            return Arrays.stream(winningNumbersInput.split(",")).map(Integer::parseInt).toList();
        }
    }

    private static void validateWinningNumbersInput(String winningNumbersInput) {
    }

    private static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_MESSAGE_PREFIX + errorMessage);
    }
}
