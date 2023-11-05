package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.*;
import lotto.domain.LottoMachine;
import lotto.util.ConverterUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void gameStart() {
        int purchaseAmount = inputView.inputPurchaseAmount();
        LottoBuyer lottoBuyer = generateLottoBuyer(purchaseAmount);
        int purchaseCount = lottoBuyer.purchaseCount();

        generateLottoStep(lottoBuyer, purchaseCount);
        WinningLotto winningLotto = generateWinningLottoStep();

        winningResultStep(lottoBuyer,winningLotto);

    }

    private LottoBuyer generateLottoBuyer(int purchaseAmount) {
        return new LottoBuyer(purchaseAmount);
    }

    private void generateLottoStep(LottoBuyer lottoBuyer, int purchaseCount) {
        LottoMachine lottoMachine = new LottoMachine();
        outputView.purchaseAmountOuput(purchaseCount);
        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = new Lotto(lottoMachine.generator());
            lottoBuyer.purchaseLotto(lotto);
        }
        outputView.purchaseHistoryOutput(lottoBuyer.getPurchaseLottos());

    }

    private WinningLotto generateWinningLottoStep() {
        List<Integer> winningNumber = ConverterUtil.covertStringToList(inputView.inputWinningNumber());
        int bounsNumber = inputView.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumber, bounsNumber);
        return winningLotto;

    }

    private void winningResultStep(LottoBuyer lottoBuyer, WinningLotto winningLotto){
        LottoResult lottoResult = new LottoResult(lottoBuyer.getPurchaseLottos(),winningLotto);

    }
    private int purchaseCount(LottoBuyer lottoBuyer) {
        return lottoBuyer.purchaseCount();

    }
}
