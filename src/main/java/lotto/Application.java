package lotto;

import lotto.controller.LottoStore;
import lotto.model.WinningStatistics;
import lotto.util.RandomLottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        WinningStatistics winningStatistics = new WinningStatistics();
        RandomLottoMachine randomLottoMachine = new RandomLottoMachine();
        LottoStore lottoStore = new LottoStore(inputView, outputView, randomLottoMachine, winningStatistics);
        lottoStore.visit();
    }
}
