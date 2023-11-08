package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.string.LottoString;

public class StartLotto {
    private long money;

    public void run() {
        initLotto();

        purchaseLotto();

        inputWinningNumber();

        printResult();
    }

    private void initLotto() {
        System.out.println(LottoString.beforePurchaseLotto());
        inputMoney();
    }

    private void inputMoney() {
        this.money = Long.parseLong(readLine());
    }

    private void purchaseLotto() {
    }

    private void inputWinningNumber() {
    }

    private void printResult() {
    }
}
