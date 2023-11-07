package lotto;

import lotto.config.LottoGameMessage;

public class OutputView {
    public OutputView(OutputWriter outputWriter) {
    }

    public void printPurchasedLottoSize(int purchased) {
        System.out.println(purchased + LottoGameMessage.OUTPUT_PURCHASED_LOTTO_SIZE.message());
    }
}
