package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.exceptions.ErrorMessages;
import lotto.model.LottoTicket;

public class UserInputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String DELIMITER = ",";
    private static final int MIN_PURCHASE_AMOUNT = 1000;
    private static final int ZERO = 0;
    private static final int MAX_LOTTO_LENGTH = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public static LottoTicket inputPurchaseAmount() {
        int lottoTicketCount;
        int purchaseAmount;
        while (true) {
            System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
            String input = Console.readLine();
            try {
                purchaseAmount = validateNumber(input);
                validateMinimumAmount(purchaseAmount);
                lottoTicketCount = validateDivisible(purchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return new LottoTicket(lottoTicketCount, purchaseAmount);
    }

    private static int validateDivisible(int purchaseAmount) {
        if ((purchaseAmount % MIN_PURCHASE_AMOUNT != ZERO)) {
            throw new IllegalArgumentException(ErrorMessages.NON_DIVISIBLE_PURCHASE_AMOUNT.getMessage());
        }
        return purchaseAmount / MIN_PURCHASE_AMOUNT;
    }

    private static void validateMinimumAmount(int purchaseAmount) {
        if ((purchaseAmount / MIN_PURCHASE_AMOUNT <= ZERO)) {
            throw new IllegalArgumentException(ErrorMessages.MIN_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static int validateNumber(String purchaseAmount) {
        if (!purchaseAmount.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_PURCHASE_AMOUNT.getMessage());
        }
        return Integer.parseInt(purchaseAmount);
    }

    public static List<Integer> inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        String input = Console.readLine();
        String[] numbers = input.split(DELIMITER);
        validateLength(numbers);
        validateDigitAndBlank(numbers);

        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : numbers) {
            String trimmedNumber = number.trim();
            int parsedNumber = Integer.parseInt(trimmedNumber);

            validateDuplicate(winningNumbers, parsedNumber);

            winningNumbers.add(parsedNumber);
        }
        return winningNumbers;
    }

    private static void validateDuplicate(List<Integer> winningNumbers, int parsedNumber) {
        if (winningNumbers.contains(parsedNumber)) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_DUPLICATE_ERROR.getMessage());
        }
    }

    private static void validateDigitAndBlank(String[] numbers) {
        for (String number : numbers) {
            String trimmedNumber = number.trim();
            validateDigit(trimmedNumber);
            validateBlank(trimmedNumber);
        }
    }

    private static void validateBlank(String trimmedNumber) {
        if (trimmedNumber.contains(" ") || trimmedNumber.contains("\t")) {
            throw new IllegalArgumentException(ErrorMessages.NON_DIGIT_AND_COMMA_ERROR.getMessage());
        }
    }

    private static void validateDigit(String trimmedNumber) {
        if (!trimmedNumber.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessages.NON_DIGIT_ERROR.getMessage());
        }
    }

    private static void validateLength(String[] numbers) {
        if (numbers.length != MAX_LOTTO_LENGTH) {
            throw new IllegalArgumentException(ErrorMessages.MAX_LENGTH_ERROR.getMessage());
        }
    }

    public static List<Integer> inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        int bonusNumber = validateNumber(input);
        validateRange(bonusNumber);
        winningNumbers.add(bonusNumber);
        return winningNumbers;
    }

    private static int validateRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_RANGE_ERROR.getMessage());
        }
        return bonusNumber;
    }
}