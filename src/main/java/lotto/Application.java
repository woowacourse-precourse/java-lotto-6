package lotto;

import lotto.controller.LottoStore;
import lotto.model.WinningStatistics;
import lotto.util.RandomLottoMachine;

public class Application {
    public static void main(String[] args) {
        LottoStore lottoStore = new LottoStore(new RandomLottoMachine(), new WinningStatistics());
        lottoStore.visit();
    }
}
