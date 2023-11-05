package lotto.view;

import lotto.handler.OutputHandler;

public class ConsoleOutput implements OutputHandler {

    @Override
    public void printInputMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    @Override
    public void printBuyLottoList() {

    }

    @Override
    public void printInputWinningLottoMessage() {

    }

    @Override
    public void printInputBonusLottoMessage() {

    }

    @Override
    public void printLottoResult() {

    }

    @Override
    public void printProfit() {

    }
}
