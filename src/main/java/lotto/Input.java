package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

import static java.util.Arrays.stream;
import static lotto.enums.Error.INPUT_ERROR;

public class Input {
    public int inputPurchaseAmount() {
        try {
            String purchaseAmount = Console.readLine();
            validatePurchaseAmount(purchaseAmount);
            return Integer.parseInt(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(INPUT_ERROR.getErrMsg());
            return inputPurchaseAmount();
        }
    }

    public List<Integer> inputWinningNumbers() {
        try {
            String inputString = Console.readLine();
            List<Integer> winningNumbers = new ArrayList<>(stream(inputString.split(","))
                    .map(Integer::valueOf)
                    .toList());
            Collections.sort(winningNumbers);
            validateWinningNumbers(winningNumbers);
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(INPUT_ERROR.getErrMsg());
            return inputWinningNumbers();
        }
    }

    public int inputBonusNumber() {
        try {
            String bonusNumber = Console.readLine();
            validateBonusNumber(bonusNumber);
            return Integer.parseInt(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(INPUT_ERROR.getErrMsg());
            return inputBonusNumber();
        }
    }

    private void validateBonusNumber(String bonusNumber) {
        int temp;
        try {
            temp = Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if (temp < 1 || temp > 45) {
            throw new IllegalArgumentException();
        }
        if (bonusNumber.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePurchaseAmount(String purchaseAmount) {
        int temp;
        if (purchaseAmount.isBlank()) {
            throw new IllegalArgumentException();
        }
        try {
            temp = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if ((temp % 1000) != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        Set<Integer> temp = new HashSet<>();
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 6; i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                throw new IllegalArgumentException();
            }
        }
        for (Integer number : numbers) {
            if (!temp.add(number)) {
                throw new IllegalArgumentException();
            }
        }
    }
}