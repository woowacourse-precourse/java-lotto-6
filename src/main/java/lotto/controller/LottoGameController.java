package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBuyer;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.util.ConverterUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void gameStart() {
        LottoBuyer lottoBuyer = generateLottoBuyer();
        generateLottoStep(lottoBuyer);
        List<Integer> winningNumber = generateWinningNumber();
        WinningLotto winningLotto = generateWinningLottoStep(winningNumber);
        winningResultStep(lottoBuyer, winningLotto);
    }

    private LottoBuyer generateLottoBuyer() {
        try {
            int purchaseAmount = inputView.inputPurchaseAmount();
            return new LottoBuyer(purchaseAmount);
        } catch (IllegalArgumentException e) {
            outputView.errorMessageOutput(e.getMessage());
            return generateLottoBuyer();
        }
    }

    private void generateLottoStep(LottoBuyer lottoBuyer) {
        LottoMachine lottoMachine = new LottoMachine();
        int purchaseCount = lottoBuyer.purchaseCount();
        outputView.purchaseAmountOuput(purchaseCount);
        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = new Lotto(lottoMachine.generator());
            lottoBuyer.purchaseLotto(lotto);
        }
        outputView.purchaseHistoryOutput(lottoBuyer.getPurchaseLottos());
    }

    private WinningLotto generateWinningLottoStep(List<Integer> winningNumber) {
        try {
            WinningLotto winningLotto = new WinningLotto(winningNumber, generateBonusNumber());
            return winningLotto;
        } catch (IllegalArgumentException e) {
            outputView.errorMessageOutput(e.getMessage());
            return generateWinningLottoStep(winningNumber);
        }
    }

    private List<Integer> generateWinningNumber() {
        try {
            return ConverterUtil.covertStringToList(inputView.inputWinningNumber());
        } catch (IllegalArgumentException e) {
            outputView.errorMessageOutput(e.getMessage());
            return generateWinningNumber();
        }
    }

    private int generateBonusNumber() {
        try {
            return inputView.inputBonusNumber();
        } catch (IllegalArgumentException e) {
            outputView.errorMessageOutput(e.getMessage());
            return generateBonusNumber();
        }
    }

    private void winningResultStep(LottoBuyer lottoBuyer, WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult(lottoBuyer.getPurchaseLottos(), winningLotto);
        lottoResult.judgeResult();
        outputView.winningStatisticOutput(lottoResult.getLottoResult());
        double totalReturn = lottoResult.getTotalReturn(lottoBuyer.getPurchaseAmount());
        outputView.totalReturnOutput(totalReturn);
    }
}
