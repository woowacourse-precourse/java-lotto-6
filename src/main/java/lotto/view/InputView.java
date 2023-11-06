package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.exception.BusinessLogicException;
import lotto.exception.ExceptionMessage;

public class InputView {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_MIN_VALUE = 1;
    private static final int LOTTO_MAX_VALUE = 45;

    public int getPurchaseAmount() {
        while (true) {
            try {
                String input = Console.readLine();
                return checkPurchaseAmount(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private int checkPurchaseAmount(String input) {
        try {
            int amount = Integer.parseInt(input);
            if (amount < LOTTO_PRICE || amount % LOTTO_PRICE != 0) {
                throw new BusinessLogicException(ExceptionMessage.INVALID_NUMBER);
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new BusinessLogicException(ExceptionMessage.INVALID_NUMBER);
        }
    }

    public List<Integer> getWinningNumbers() {
        while (true) {
            try {
                String input = Console.readLine();
                return checkWinningNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private List<Integer> checkWinningNumbers(String input) {
        try {
            List<Integer> inputNumbers = splitWinningNumbers(input);
            validWinningNumbers(inputNumbers);
            return inputNumbers;
        } catch (NumberFormatException e) {
            throw new BusinessLogicException(ExceptionMessage.INVALID_WINNING_NUMBER);
        }
    }

    private List<Integer> splitWinningNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    private void validWinningNumbers(List<Integer> inputNumbers) {
        // 번호 6개 맞는지 확인
        if (inputNumbers.size() != 6 || Collections.min(inputNumbers) < LOTTO_MIN_VALUE
                || Collections.max(inputNumbers) > LOTTO_MAX_VALUE) {
            throw new BusinessLogicException(ExceptionMessage.INVALID_WINNING_NUMBER);
        }
        // 중복값 없는지 확인
        Set<Integer> uniqueNumbers = new HashSet<>(inputNumbers);
        if (inputNumbers.size() > uniqueNumbers.size()) {
            throw new BusinessLogicException(ExceptionMessage.INVALID_WINNING_NUMBER);
        }
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String input = Console.readLine();
                int bonusNumber = checkBonusNumber(input);
                validBonusNumber(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private int checkBonusNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new BusinessLogicException(ExceptionMessage.INVALID_BONUS_NUMBER);
        }
    }

    private void validBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber) || bonusNumber < LOTTO_MIN_VALUE || bonusNumber > LOTTO_MAX_VALUE) {
            throw new BusinessLogicException(ExceptionMessage.INVALID_BONUS_NUMBER);
        }
    }
}
