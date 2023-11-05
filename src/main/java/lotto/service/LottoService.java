package lotto.service;

import lotto.view.InputView;

public class LottoService {

    public static int getAmountOfLottoTickets() {
        int money = InputView.inputMoney();
        int amountOfLottoTickets = money / 1000;

        // [예외처리] 1000원으로 나누어 떨어지지 않는 경우

        return amountOfLottoTickets;
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
