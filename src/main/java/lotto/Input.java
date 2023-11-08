package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

import static java.util.Arrays.stream;
import static lotto.Error.*;

public class Input {
    public String input() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(INPUT_EMPTY.getErrMsg());
        }
    }

    public int inputPurchaseAmount() {
        String purchaseAmount = input();
        validatePurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    public List<Integer> inputWinningNumbers() {
        String inputString = input();
        List<Integer> winningNumbers = new ArrayList<>(stream(inputString.split(","))
                .map(Integer::valueOf)
                .toList());
        Collections.sort(winningNumbers);
        validateWinningNumbersSize(winningNumbers);
        validateWinningNumbersVal(winningNumbers);
        validateDuplication(winningNumbers);
        return winningNumbers;
    }

    public int inputBonusNumber() {
        String bonusNumber = input();
        validateBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    private void validateBonusNumber(String value) {
        int temp;
        try {
            temp = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_VALUE.getErrMsg());
        }
        if (temp < 1 || temp > 45) {
            throw new IllegalArgumentException(INVALID_NUMBERS_VALUE.getErrMsg());
        }
    }

    private void validatePurchaseAmount(String purchaseAmount) {
        int temp;
        try {
            temp = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_VALUE.getErrMsg());
        }
        if ((temp / 1000) != 0) {
            throw new IllegalArgumentException(UNDIVIDED_PURCHASE_AMOUNT.getErrMsg());
        }
    }

    private void validateWinningNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBERS_SIZE.getErrMsg());
        }
    }

    private void validateWinningNumbersVal(List<Integer> numbers) {
        for (int i = 0; i < 6; i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                throw new IllegalArgumentException(INVALID_NUMBERS_VALUE.getErrMsg());
            }
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> temp = new HashSet<>();
        for (Integer number : numbers) {
            if (!temp.add(number)) {
                throw new IllegalArgumentException(DUPLICATE_NUMBERS.getErrMsg());
            }
        }
    }
}