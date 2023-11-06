package lotto.controller;

import static lotto.domain.constant.DomainConstant.ONE_LOTTO_PRICE;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.LottoResult;
import lotto.domain.money.Money;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoGenerator lottoGenerator;

    public LottoController() {
        this(new LottoGenerator());
    }

    public LottoController(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public void play() {
        UserLotto userLotto = receiveUserLotto();
        Money purchaseAmount = new Money(userLotto.getLottoCount() * ONE_LOTTO_PRICE);
        displayUserLotto(userLotto);

        WinningLotto winningLotto = receiveWinningLottoNumber();

        LottoResult lottoResult = userLotto.compareAllLotto(winningLotto);

        printLottoResultStatistics(lottoResult, purchaseAmount);
    }

    private void displayUserLotto(UserLotto userLotto) {
        long totalLotto = userLotto.getLottoCount();
        String allLotto = userLotto.displayAllLotto();

        outputView.printNewLine();
        outputView.printUserLotto(totalLotto, allLotto);
    }

    private UserLotto receiveUserLotto() {
        Money purchaseAmount = receivePurchaseAmount();
        List<Lotto> userLottoNumbers = lottoGenerator.createLottoByPrice(purchaseAmount);

        return new UserLotto(userLottoNumbers);
    }

    private Money receivePurchaseAmount() {
        long purchaseAmount;
        while (true) {
            try {
                outputView.requestAmount();
                purchaseAmount = inputView.receivePurchaseAmount();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
                outputView.printNewLine();
            }
        }
        return new Money(purchaseAmount);
    }

    private WinningLotto receiveWinningLottoNumber() {
        String winningNumbers = receiveWinningNumber();
        int bonusNumber = receiveBonusNumber(winningNumbers);
        outputView.printNewLine();

        return lottoGenerator.createWinningLottoFromInput(winningNumbers, bonusNumber);
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
                outputView.printNewLine();
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
                outputView.printNewLine();
            }
        }

        return bonusNumber;
    }

    private void printLottoResultStatistics(LottoResult lottoResult, Money purchaseAmount) {
        Money totalRevenue = lottoResult.getTotalRevenue();
        outputView.printStatistics(lottoResult.getStatistics());
        outputView.printEarningRate(purchaseAmount.amount(), totalRevenue.amount());
    }
}
