package lotto.controller;

import static lotto.constant.Constant.ONE_LOTTO_PRICE;

import java.util.List;
import lotto.domain.Lotto;
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

    public void play() {
        UserLottos userLottos = receiveUserLottos();
        int purchaseAmount = userLottos.getTotalLottos() * ONE_LOTTO_PRICE;
        displayUserLotto(userLottos);

        WinningLotto winningLotto = receiveWinningLottoNumber();

        LottoResult lottoResult = userLottos.compareAllLottos(winningLotto);

        printLottoResultStatistics(lottoResult, purchaseAmount);
    }

    private void displayUserLotto(UserLottos userLottos) {
        int totalLotto = userLottos.getTotalLottos();
        String allLotto = userLottos.displayAllLottos();

        outputView.printNewLine();
        outputView.printUserLotto(totalLotto, allLotto);
    }

    private UserLottos receiveUserLottos() {
        int purchaseAmount = receivePurchaseAmount();
        List<Lotto> userLottoNumbers = lottoMaker.createLottoByPrice(purchaseAmount);

        return new UserLottos(userLottoNumbers);
    }

    private int receivePurchaseAmount() {
        int purchaseAmount;
        while (true) {
            try {
                outputView.requestAmount();
                purchaseAmount = inputView.receivePurchaseAmount();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
        return purchaseAmount;
    }

    private WinningLotto receiveWinningLottoNumber() {
        String winningNumbers = receiveWinningNumber();
        int bonusNumber = receiveBonusNumber(winningNumbers);
        outputView.printNewLine();

        return lottoMaker.createWinningLottoFromInput(winningNumbers, bonusNumber);
    }

    private String receiveWinningNumber() {
        String winningNumber;
        while (true) {
            try {
                outputView.requestWinningNumber();
                winningNumber = inputView.receiveWinningNumber();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
        outputView.printNewLine();
        return winningNumber;
    }

    private int receiveBonusNumber(String winningNumbers) {
        int bonusNumber;
        while (true) {
            try {
                outputView.requestBonusNumber();
                bonusNumber = inputView.receiveBonusNumber(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }

        return bonusNumber;
    }

    private void printLottoResultStatistics(LottoResult lottoResult, int purchaseAmount) {
        outputView.printStatistics(lottoResult.getStatistics());
        outputView.printEarningRate(purchaseAmount, lottoResult.getTotalRevenue());
    }
}
