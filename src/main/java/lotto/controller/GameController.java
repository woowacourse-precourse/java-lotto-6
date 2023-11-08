package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.service.LottoWinningCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    private static int bonusNumber;
    private static List<Lotto> lottoNumber;
    private static Lotto winningNumbers;
    private static int purchaseAmount;


    public static int play() {
        OutputView.printGameStartMessage();
        purchaseAmount = InputView.inputPurchaseAmount();
        return lottoPurchaseNum(purchaseAmount);
    }

    private static int lottoPurchaseNum(int purchaseAmount) {
        lottoNumber = LottoService.generateLottoNumbers(purchaseAmount);
        OutputView.printLottoPurchaseAmount(purchaseAmount);
        OutputView.printLottoNumber(lottoNumber);
        lottoInputWinningNum();
        return purchaseAmount;
    }

    private static void lottoInputWinningNum() {
        winningNumbers = InputView.inputWinningNum();
        lottoPrintBonusNumber();
    }

    private static void lottoPrintBonusNumber() {
        OutputView.printLottoBonusNumber();
        bonusNumber = InputView.inputBonusNum(winningNumbers);
        OutputView.printLottoWinningStatistics();
        lottoWinningCalculator();
    }

    private static void lottoWinningCalculator() {
        LottoWinningCalculator.calculatorLotto(lottoNumber, winningNumbers, bonusNumber, purchaseAmount);
    }
}

