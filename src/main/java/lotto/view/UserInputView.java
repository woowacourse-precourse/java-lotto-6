package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ErrorMessages;
import lotto.model.LottoResult;
import lotto.model.LottoTickets;

public class UserInputView {

    private static final String INPUT_BUY_AMOUNT_MESSAGE = "구매금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String DELIMITER = ",";
    private static final int MIN_LOTTO_NUMBER_RANGE = 1;
    private static final int MAX_LOTTO_NUMBER_RANGE = 45;

    public static LottoTickets inputBuyAmount() {
        while (true) {
            System.out.println(INPUT_BUY_AMOUNT_MESSAGE);
            String input = Console.readLine();
            try {
                int buyAmount = validateNumber(input);
                return new LottoTickets(buyAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        String input = Console.readLine();
        String[] inputNumbers = input.split(DELIMITER);
        validateLength(inputNumbers);
        validateDuplicate(winningNumbers, inputNumbers);
        validateRange(winningNumbers);
        return winningNumbers;
    }

    private static void validateRange(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            if (number < MIN_LOTTO_NUMBER_RANGE || number > MAX_LOTTO_NUMBER_RANGE) {
                throw new IllegalArgumentException(ErrorMessages.INVALID_RANGE.getMessage());
            }
        }
    }

    private static void validateDuplicate(List<Integer> winningNumbers, String[] inputNumbers) {
        for (String numStr : inputNumbers) {
            int num = validateNumber(numStr);
            if (winningNumbers.contains(num)) {
                throw new IllegalArgumentException(ErrorMessages.DUPLICATE_NUMBER.getMessage());
            }
            winningNumbers.add(num);
        }
    }

    private static void validateLength(String[] inputNumbers) {
        if (inputNumbers.length != 6) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_WINNING_NUMBER_COUNT.getMessage());
        }
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        int bonusNumber = validateNumber(input);
        validateRange(bonusNumber);
        return bonusNumber;
    }

    private static int validateNumber(String purchaseAmount) {
        if (!purchaseAmount.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_INVALID_NUMBER.getMessage());
        }
        return Integer.parseInt(purchaseAmount);
    }

    private static void validateRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_RANGE.getMessage());
        }
    }
}
