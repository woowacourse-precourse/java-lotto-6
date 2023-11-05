package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PlayerLotto;
import lotto.domain.Unit;
import lotto.domain.WinningLotto;
import lotto.dto.ComparatorRequest;
import lotto.service.LottoCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputController inputController;
    private final LottoCalculator lottoCalculator;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.inputController = new InputController();
        this.lottoCalculator = new LottoCalculator();
    }

    public void play() {
        int purchasePrice = inputController.inputPurchasePrice();
        List<Lotto> playerNumbers = purchaseLotto(purchasePrice);
        WinningLotto winningLotto = generateWinningLotto();

        ComparatorRequest comparatorRequest = new ComparatorRequest(winningLotto, playerNumbers);
        lottoCalculator.compareLotto(comparatorRequest);
        outputView.showResult();
        outputView.showPayOff(lottoCalculator.calculatePayOff(purchasePrice));
    }

    private List<Lotto> purchaseLotto(int purchasePrice) {
        int buyingCount = Unit.getPurchaseNumber(purchasePrice);
        outputView.showPurchaseMessage(buyingCount);

        PlayerLotto playerLotto = new PlayerLotto();
        List<Lotto> playerNumbers = playerLotto.generatePlayerNumbers(buyingCount);
        outputView.showPurchasedLottoNumbers(playerNumbers);
        return playerNumbers;
    }

    private WinningLotto generateWinningLotto(){
        boolean isTrue = false;
        Lotto lotto = null;
        while (!isTrue) {
            inputView.showInputWinningNumberMessage();
            try {
                lotto = new Lotto(inputController.inputLottoNumbers());
                isTrue = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return new WinningLotto(lotto, inputController.checkBonusNumber(lotto.getNumbers()));
    }
}
