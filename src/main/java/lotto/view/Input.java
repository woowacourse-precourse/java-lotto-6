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

    List<Integer> splitNumbers(String str) {
        List<Integer> numbers = new ArrayList<>();
        String[] numStrs = str.split(",");
        for (String numStr : numStrs) {
            int num = Integer.parseInt(numStr);
            validateNumber(num);
            numbers.add(num);
        }
        return numbers;
    }

}
