package lotto.service;

import lotto.view.InputView;

public class lottoService {

    public static int getAmountOfTickets() {
        int money = InputView.inputMoney();
        int amountOfTickets = money / 1000;

        // [예외처리] 1000원으로 나누어 떨어지지 않는 경우

        return amountOfTickets;
    }
    public void makeLottoTickets() {
    }
    public void compareWithWinningNumbers() {

    }
    public void makeStatistics() {

    }
    public void getEarningRate() {

    }
}
