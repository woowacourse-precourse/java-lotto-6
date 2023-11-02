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

        Arrays.stream(Console.readLine().split(","))
                .toList()
                .forEach(s -> winningNumbers.add(Integer.valueOf(s)));

        if (NumberCheckValidator.validateWinningNumber(winningNumbers)) {
            return winningNumbers;
        }
        throw new IllegalArgumentException("[ERROR] 1 ~ 45사이의 숫자를 중복없이 입력해 주세요");
    }

    public int inputBonusNumber() {
        int bonusNumber = Integer.parseInt(Console.readLine());
        if (NumberCheckValidator.validateBonusNumber(winningNumbers,bonusNumber)) {
            return bonusNumber;
        }
        throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이 숫자 중 로또번호와 중복되지 않는 수를 입력해 주세요");
    }
}
