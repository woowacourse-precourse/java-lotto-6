package lotto.controller;

import lotto.domain.LottoMaker;
import lotto.domain.LottoResult;
import lotto.domain.UserLottos;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoMaker lottoMaker;

    public LottoController() {
        this(new LottoMaker());
    }

    public LottoController(LottoMaker lottoMaker) {
        this.lottoMaker = lottoMaker;
    }

    public void playGame() {
        int purchaseAmount = receivePurchaseAmount();
        UserLottos userLottos = new UserLottos(lottoMaker.createLottosByPrice(purchaseAmount));
        outputView.printUserLottos(userLottos.getTotalLottos(), userLottos.displayAllLottos());

        WinningLotto winningLotto = lottoMaker.createWinningLottoFromInput(
                inputView.receiveWinningNumber(),
                inputView.receiveBonusNumber()
        );

        LottoResult lottoResult = userLottos.compareAllLottos(winningLotto);

        outputView.printResults(lottoResult.getStatistics());
        outputView.printEarningRate(purchaseAmount, lottoResult.getTotalRevenue());
    }

    private int receivePurchaseAmount() {
        int purchaseAmount = 0;
        try {
            purchaseAmount = inputView.receivePurchaseAmount();
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            receivePurchaseAmount();
        }
        return purchaseAmount;
    }
}
