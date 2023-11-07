package lotto.controller;

import java.util.List;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.service.LottoWinningCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    public static int play() {
        OutputView.printGameStartMessage();
        int purchaseAmount = InputView.inputPurchaseAmount();
        return lottoPurchaseNum(purchaseAmount);
    }

    private static int lottoPurchaseNum(int purchaseAmount) {
        List<Lotto> lottoNum = LottoService.generateLottoNumbers(purchaseAmount);
        OutputView.printLottoPurchaseAmount(purchaseAmount);
        OutputView.printLottoNumber(lottoNum);
        lottoInputWinningNum();
        return purchaseAmount;
    }

    public static void lottoInputWinningNum() {
        Lotto winningNumbers = InputView.inputWinningNum();
        lottoPrintBonusNumber(winningNumbers);
    }

    public static int lottoPrintBonusNumber(Lotto winningNumbers) {
        OutputView.printLottoBonusNumber();
        int bonusNumber = InputView.inputBonusNum(winningNumbers);
        OutputView.printLottoWinningStatistics();
        return bonusNumber;
    }
}

