package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int printAskingBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(getUserInput());
    }

    public String getUserInput() {
        return Console.readLine().trim();
    }

    public void close() {
        Console.close();
    }
}
