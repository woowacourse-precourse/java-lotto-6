package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    int inputAmount() {
        int amount = Integer.parseInt(Console.readLine());
        validateAmount(amount);
        return amount;
    }

    void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요");
        }
    }
}
