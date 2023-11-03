package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Amount {

    public Amount() {
    }

    public int enterAmount() {
        int amount = 0;

        printAmountEnterGuideStatement();
        String input = Console.readLine();

        return amount;
    }

    private void printAmountEnterGuideStatement() {
        System.out.println("구입 금액을 입력해 주세요");
    }
}
