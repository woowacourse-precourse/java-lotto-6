package lotto.controller;

import java.util.List;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.service.LottoWinningCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    private static int purchaseAmount;
    private static int bonusNumber;
    private static Lotto winningNumbers;
    private static List<List<Integer>> allLottoNumbers;

    public void play() {
        OutputView.printGameStartMessage();
        purchaseAmount = InputView.inputPurchaseAmount();
        lottoPurchaseNum(purchaseAmount);
    }

    private void lottoPurchaseNum(int lottoNum) {
        allLottoNumbers = LottoService.generateLottoNumbers(lottoNum);
        OutputView.printLottoPurchaseAmount(lottoNum);
        lottoPrintNum(allLottoNumbers);
    }

    public static void lottoPrintNum(List<List<Integer>> lottoAllNumbers) {
        OutputView.printLottoNumber(lottoAllNumbers);
        lottoInputWinningNum();
    }

    public static void lottoInputWinningNum() {
        winningNumbers = InputView.inputWinningNum();
        lottoPrintBonusNumber(winningNumbers);
    }

    public static void lottoPrintBonusNumber(Lotto winningNumbers) {
        OutputView.printLottoBonusNumber();
        bonusNumber = InputView.inputBonusNum(winningNumbers);
        OutputView.printLottoWinningStatistics();
        lottoWinCalculator();
    }

    public static void lottoWinCalculator() {
        LottoWinningCalculator.lottoCalculator(winningNumbers, allLottoNumbers, purchaseAmount, bonusNumber);
     //   LottoWinningCalculator.winningCalculator(winningNumbers, allLottoNumbers, purchaseAmount, bonusNumber);
    }
}

