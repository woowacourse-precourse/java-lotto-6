package lotto.controller;

import java.util.List;
import lotto.domain.Consumer;
import lotto.domain.Winning;
import lotto.domain.lotto.Lotto;
import lotto.service.LottoStore;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameManager {
    private InputView inputView;
    private OutputView outputView;
    private LottoStore lottoStore;

    private Consumer consumer = new Consumer();
    private Winning winning = new Winning();

    public LottoGameManager(InputView inputView, OutputView outputView, LottoStore lottoStore) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoStore = lottoStore;
    }

    public void play() {
        enterPurchaseAmount();
        printLottos();
        enterWinningNumber();
    }

    private void enterPurchaseAmount() {
        while (true) {
            try {
                int purchaseAmount = inputView.enterPurchaseAmount();
                consumer.setPurchaseAmount(purchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void printLottos() {
        List<Lotto> lottos = lottoStore.createLottos(consumer.getPurchaseAmount());
        consumer.setLottos(lottos);

        outputView.printLottos(consumer);
    }

    private void enterWinningNumber() {
        while (true) {
            try {
                winning.setNumbers(inputView.enterWinningNumber());
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }

    }
}
