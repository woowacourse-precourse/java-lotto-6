package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.AmountCheckValidator;
import lotto.validation.NumberCheckValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.validation.AmountCheckValidator.*;
import static lotto.validation.NumberCheckValidator.*;

public class User {
    private int count;
    private List<Integer> winningNumbers = new ArrayList<>();

    public User() {
    }

    public int inputAmount() {
        int amount = Integer.parseInt(Console.readLine());
        retryAmount(amount);
        return count;
    }

    private void injectCount(int amount) {
        count = amount / 1_000;
    }

    public List<Integer> inputWinningNumbers() {
        Arrays.stream(Console.readLine().split(",")).toList()
                .forEach(s -> winningNumbers.add(Integer.valueOf(s)));

        retryWinningNumber();
        return winningNumbers;
    }

    public int inputBonusNumber() {
        int bonusNumber = Integer.parseInt(Console.readLine());
        retryBonusNumber(bonusNumber);
        return bonusNumber;
    }

    private void retryAmount(int amount) {
        try {
            validateAmount(amount);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            inputAmount();
        }
    }

    private void retryWinningNumber() {
        try {
            validateWinningNumber(winningNumbers);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            inputWinningNumbers();
        }
    }

    private void retryBonusNumber(int bonusNumber) {
        try {
            validateBonusNumber(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            inputBonusNumber();
        }
    }
}