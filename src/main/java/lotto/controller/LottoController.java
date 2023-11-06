package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPublisher;
import lotto.view.OutputView;

public class LottoController {
    private final InputController inputController;
    public LottoController() {
        inputController = new InputController();
        playLottoGame();
    }

    private void playLottoGame() {
        LottoPublisher lottoPublisher =  inputController.getPurchasePrice();
        printLottoInformation(lottoPublisher);
    }

    private void printLottoInformation(LottoPublisher lottoPublisher) {
        OutputView.printPurchaseCount(lottoPublisher.getLottoAmount());
        printLotto(lottoPublisher.getUserLottos());
    }

    private void printLotto(List<Lotto> userLottos) {
        for (Lotto lotto : userLottos) {
            OutputView.printLottoNumbers(lotto.getNumbers());
        }
    }

}
