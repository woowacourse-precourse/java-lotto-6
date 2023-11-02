package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.AmountCheckValidator;
import lotto.validation.NumberCheckValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private int count;
    private List<Integer> winningNumbers = new ArrayList<>();

    public User() {
    }

    public int inputAmount() {
        int amount = Integer.parseInt(Console.readLine());

        if (AmountCheckValidator.validateAmount(amount)) {
            injectCount(amount);
            return count;
        }
        throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위로 입력해 주세요");
    }

    private void injectCount(int amount) {
        count = amount / 1_000;
    }

    public List<Integer> inputWinningNumbers() {
        Arrays.stream(Console.readLine().split(",")).toList().forEach(s -> winningNumbers.add(Integer.valueOf(s)));

        retry();

        return winningNumbers;
    }

    public int inputBonusNumber() {
        int bonusNumber = Integer.parseInt(Console.readLine());

        retry(bonusNumber);

        return bonusNumber;
    }

    private void retry() {
        try {
            NumberCheckValidator.validateWinningNumber(winningNumbers);
        } catch (IllegalArgumentException e) {
            inputWinningNumbers();
        }
    }

    private void retry(int bonusNumber) {
        try {
            NumberCheckValidator.validateBonusNumber(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            inputBonusNumber();
        }
    }
}
