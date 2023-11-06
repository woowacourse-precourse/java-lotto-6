package lotto.controller;

import java.util.List;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    public void play() {
        OutputView.printGameStartMessage();
        int lottoNumber = InputView.inputPurchaseAmount();
        lottoPurchaseNum(lottoNumber);
        OutputView.printLottoWinningStatistics();
    }

    private void lottoPurchaseNum(int lottoNum) {
        List<List<Integer>> allLottoNumbers = LottoService.generateLottoNumbers(lottoNum);
        OutputView.printLottoPurchaseAmount(lottoNum);
        lottoPrintNum(allLottoNumbers);
    }

    public static void lottoPrintNum(List<List<Integer>> lottoAllNumbers) {
        OutputView.printLottoNumber(lottoAllNumbers);
        lottoInputWinningNum();
    }

    public static void lottoInputWinningNum() {
        Lotto winningNumbers = InputView.inputWinningNum();
        lottoPrintBonusNumber(winningNumbers);
    }

    public static void lottoPrintBonusNumber(Lotto winningNumbers) {
        OutputView.printLottoBonusNumber();
        int bonusNumber = InputView.inputBonusNum(winningNumbers);
        winningStatistics();
    }

    public static void winningStatistics() {
        OutputView.printLottoWinningStatistics();
    }
}