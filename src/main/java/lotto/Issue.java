package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Issue {
    private int lottoQuantity;

    void inputCash() {
        int cash = Integer.parseInt(Console.readLine());
        lottoQuantity = cash / 1000;
    }

    void playIssue() {
        inputCash();
    }
}
