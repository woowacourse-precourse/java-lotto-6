package lotto.domain.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import lotto.global.constant.ConsoleType;
import lotto.global.view.InputView;
import lotto.global.view.OutputView;

public class ClientService {

    private static final String SPLITTER = ",";
    private static final int UNIT = 1000;
    private static final int MIN_RANGE_OF_WINNING_NUMBER = 1;
    private static final int MAX_RANGE_OF_WINNING_NUMBER = 45;

    public long getPurchaseAmount() {
        try {
            long purchaseAmount = Long.parseLong(InputView.input());
            validatePurchaseAmount(purchaseAmount);
            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            OutputView.commonOutputLine(ConsoleType.EXCEPTION.getComment());
            return getPurchaseAmount();
        }
    }

    public List<Integer> getWinningNumbers() {
        String input = InputView.input();
        try {
            List<Integer> numbers = new ArrayList<>(Arrays.stream(input.split(SPLITTER))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .peek(this::validateNumberRange)
                    .toList());
            validateSize(numbers);
            validateUnique(numbers);
            numbers.sort(Comparator.naturalOrder());
            return numbers;
        } catch (IllegalArgumentException e) {
            OutputView.commonOutputLine(ConsoleType.EXCEPTION.getComment());
            return getWinningNumbers();
        }
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        try {
            int bonusNumber = Integer.parseInt(InputView.input());
            validateBonusNumber(winningNumbers, bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            OutputView.commonOutputLine(ConsoleType.EXCEPTION.getComment());
            return getBonusNumber(winningNumbers);
        }
    }

    private void validateUnique(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBonusNumber(List<Integer> winningNumbers, Integer number) {
        validateNumberRange(number);
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(ConsoleType.EXCEPTION.getComment());
        }
    }

    private void validateNumberRange(Integer winningNumber) {
        if (!(winningNumber >= MIN_RANGE_OF_WINNING_NUMBER && winningNumber <= MAX_RANGE_OF_WINNING_NUMBER)) {
            throw new IllegalArgumentException(ConsoleType.EXCEPTION.getComment());
        }
    }

    private void validatePurchaseAmount(long purchaseAmount) {
        if (isNotValidAmountRange(purchaseAmount) || isNotValidUnit(purchaseAmount)) {
            throw new IllegalArgumentException(ConsoleType.EXCEPTION.getComment());
        }
    }

    private boolean isNotValidUnit(long purchaseAmount) {
        return purchaseAmount % UNIT != 0;
    }

    private boolean isNotValidAmountRange(long purchaseAmount) {
        return purchaseAmount < 0;
    }
}