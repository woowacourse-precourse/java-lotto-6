package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Prize;
import lotto.domain.PrizeResult;
import lotto.domain.WinningLotto;
import lotto.utils.Constants;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private List<Lotto> lottos;
    private int lottoCount;
    private int purchaseAmount;

    public void run() {
        purchaseLotto();
        checkWinning();
    }

    private void purchaseLotto() {
        purchaseAmount = InputView.inputPurchaseAmount();

        lottoCount = purchaseAmount / Constants.LOTTO_TICKET_PRICE;
        lottos = LottoGenerator.createLottos(lottoCount);

        OutputView.printNewLine();
        OutputView.printTicketCount(lottoCount);
        printLottoNumbers();
    }

    private void printLottoNumbers() {
        for (Lotto lotto : lottos) {
            OutputView.printLottoNumbers(lotto);
        }
        OutputView.printNewLine();
    }

    private void checkWinning() {
        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        OutputView.printNewLine();
        int bonusNumber = InputView.inputBonusNumber(winningNumbers);
        OutputView.printNewLine();

        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);
        PrizeResult prizeResult = getPrizeResult(winningLotto);

        OutputView.printPrizeResult(prizeResult, purchaseAmount);
    }

    private PrizeResult getPrizeResult(WinningLotto winningLotto) {
        PrizeResult prizeResult = new PrizeResult();
        for (Lotto lotto : lottos) {
            Prize prize = winningLotto.match(lotto);
            prizeResult.addPrize(prize);
        }
        return prizeResult;
    }
}
