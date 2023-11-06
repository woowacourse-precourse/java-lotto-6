package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Application {
    private static final String MESSAGE_FOR_PURCHASE_AMOUNT_INPUT = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_FOR_WINNING_NUMBERS_INPUT = "당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_FOR_BONUS_NUMBERS_INPUT = "보너스 번호를 입력해 주세요.";

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final String ERROR_MESSAGE_FOR_PURCHASE_AMOUNT_INPUT = "구앱금액은 1000원 단위로 숫자를 입력해 주세요.";
    private static final String ERROR_MESSAGE_FOR_WINNING_NUMBER_TYPE = "로또 번호는 숫자여야 합니다.";
    private static final String ERROR_MESSAGE_FOR_WINNING_NUMBER_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_MESSAGE_FOR_WINNING_NUMBER_COUNT = "로또 번호는 6개 숫자여야 합니다.";
    private static final String ERROR_MESSAGE_FOR_WINNING_NUMBER_DUPLICATE = "로또 번호는 중복되지 않은 숫자여야 합니다.";

    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmountWithInput();
        List<Integer> winningNumbers = getWinningNumbersWithInput();
        int bonusNumber = getBonusNumberWithInput();
    }

    private static int getBonusNumberWithInput() {
        System.out.println(MESSAGE_FOR_BONUS_NUMBERS_INPUT);
        return 0;
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
        List<String> winningNumbersStrings = Arrays.stream(winningNumbersInput.split(",")).toList();
        List<Integer> winningNumbers = new ArrayList<>();
        for (String numberString: winningNumbersStrings) {
            try {
                int number = Integer.parseInt(numberString);
                winningNumbers.add(number);
            } catch (NumberFormatException e) {
                printErrorMessage(ERROR_MESSAGE_FOR_WINNING_NUMBER_TYPE);
                throw new IllegalArgumentException();
            }
        }

        if (winningNumbers.size() != 6) {
            printErrorMessage(ERROR_MESSAGE_FOR_WINNING_NUMBER_COUNT);
            throw new IllegalArgumentException();
        }

        for (int number: winningNumbers) {
            if (number < 1 || number > 45) {
                printErrorMessage(ERROR_MESSAGE_FOR_WINNING_NUMBER_RANGE);
                throw new IllegalArgumentException();
            }
        }

        Set<Integer> winningNumberSet = Set.copyOf(winningNumbers);
        if (winningNumberSet.size() != 6) {
            printErrorMessage(ERROR_MESSAGE_FOR_WINNING_NUMBER_DUPLICATE);
            throw new IllegalArgumentException();
        }
    }

    private static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_MESSAGE_PREFIX + errorMessage);
    }
}
