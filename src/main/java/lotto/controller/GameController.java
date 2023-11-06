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
        int purchaseLottoNumber = Unit.calculateLottoTicketCanPurchase(purchasePrice);
        List<Lotto> playerNumbers = generateLottoNumbers(purchaseLottoNumber);
        WinningLotto winningLotto = generateWinningLotto();

        ComparatorRequest comparatorRequest = new ComparatorRequest(winningLotto, playerNumbers);
        lottoCalculator.compareLotto(comparatorRequest);
        outputView.showResult();
        outputView.showPayOff(lottoCalculator.calculatePayOff(purchasePrice));
    }

    private List<Lotto> generateLottoNumbers(int purchasePrice) {
        outputView.showPurchaseMessage(purchasePrice);

        PlayerLotto playerLotto = new PlayerLotto();
        List<Lotto> playerNumbers = playerLotto.generatePlayerNumbers(purchasePrice);
        outputView.showPurchasedLottoNumbers(playerNumbers);
        return playerNumbers;
    }

    private WinningLotto generateWinningLotto() {
        Lotto lotto;
        inputView.showInputWinningNumberMessage();
        while (true) {
            try {
                List<Integer> numbers = inputController.inputLottoNumbers();
                lotto = new Lotto(numbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return new WinningLotto(lotto, inputController.checkBonusNumber(lotto.getNumbers()));
    }
}
