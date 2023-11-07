package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Input {

    Output output;
    int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        validateAmount(amount);
        System.out.printf("\n%d개를 구매했습니다.\n", (int)amount / 1000);
        return amount;
    }

    void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요");
        }
    }

    List<Integer> inputNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
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

    void validateNumber(int num) {
        if ((num <= 0) || (num > 45)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    int inputBonus() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

}
