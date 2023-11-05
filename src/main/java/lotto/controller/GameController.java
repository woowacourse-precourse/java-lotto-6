package lotto.controller;

import java.util.List;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    public void play() {
        OutputView.printGameStartMessage();
        int purchaseInput = InputView.inputPurchaseAmount();
        lottoPurchaseNum(purchaseInput);
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
        InputView.inputWinningNum();
        lottoPrintBonusNumber();
    }

    public static void lottoPrintBonusNumber() {
        OutputView.printLottoBonusNumber();
    }
}
