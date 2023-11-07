package lotto;

public class Application {
    public static void main(String[] args) {
        LottoSeller lottoSeller = new LottoSeller();
        lottoSeller.buyLotto();

        WinningNumberManager winningNumberManager = new WinningNumberManager();
        winningNumberManager.setWinningNumberToLottoMachine();

        lottoSeller.noticeStatistic();
    }
}
