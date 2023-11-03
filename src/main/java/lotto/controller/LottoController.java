package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMaker;
import lotto.domain.LottoResult;
import lotto.domain.UserLottos;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static final int ONE_LOTTO_PRICE = 1000;
    private static final int DEFAULT_INT_VALUE = 0;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoMaker lottoMaker;


    public LottoController() {
        this(new LottoMaker());
    }

    public LottoController(LottoMaker lottoMaker) {
        this.lottoMaker = lottoMaker;
    }

    public void play() {
        UserLottos userLottos = receiveUserLottos();
        WinningLotto winningLotto = receiveWinningLottoNumber();

        LottoResult lottoResult = userLottos.compareAllLottos(winningLotto);

        int purchaseAmount = userLottos.getTotalLottos() * ONE_LOTTO_PRICE;
        printLottoResultStatistics(lottoResult, purchaseAmount);
    }

    private UserLottos receiveUserLottos() {
        int purchaseAmount = receivePurchaseAmount();
        List<Lotto> userLottoNumbers = lottoMaker.createLottosByPrice(purchaseAmount);
        UserLottos userLottos = new UserLottos(userLottoNumbers);

        outputView.printUserLottos(userLottos.getTotalLottos(), userLottos.displayAllLottos());

        return userLottos;
    }

    private int receivePurchaseAmount() {
        int purchaseAmount = DEFAULT_INT_VALUE;
        try {
            purchaseAmount = inputView.receivePurchaseAmount();
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            receivePurchaseAmount();
        }
        return purchaseAmount;
    }

    private WinningLotto receiveWinningLottoNumber() {
        String winningNumbers = receiveWinningNumber();
        int bonusNumber = receiveBonusNumber();

        return lottoMaker.createWinningLottoFromInput(winningNumbers, bonusNumber);
    }

    private String receiveWinningNumber() {
        String winningNumber = null;
        try {
            winningNumber = inputView.receiveWinningNumber();
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            receiveWinningNumber();
        }
        return winningNumber;
    }

    private int receiveBonusNumber() {
        int bonusNumber = DEFAULT_INT_VALUE;
        try {
            bonusNumber = inputView.receiveBonusNumber();
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            receiveBonusNumber();
        }
        return bonusNumber;
    }

    private void printLottoResultStatistics(LottoResult lottoResult, int purchaseAmount) {
        outputView.printResults(lottoResult.getStatistics());
        outputView.printEarningRate(purchaseAmount, lottoResult.getTotalRevenue());
    }
}
