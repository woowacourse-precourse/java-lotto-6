package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Input {

    Output output;
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

    List<Integer> inputNumbers() {
        List<Integer> lotto;
        while (true) {
            try {
                lotto = splitNumbers(Console.readLine());
                break;
            } catch (IllegalArgumentException e) {
                output.printError(e);
            }
        }
        return lotto;
    }


}
