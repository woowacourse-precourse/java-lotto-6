package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        int purchaseAmount = InputView.inputPurchaseAmount();

        int lottoCount = purchaseAmount / 1000;
        List<Lotto> lottos = LottoGenerator.createLottos(lottoCount);

        OutputView.printNewLine();
        OutputView.printTicketCount(lottoCount);

        for (Lotto lotto : lottos) {
            OutputView.printLottoNumbers(lotto);
        }

        OutputView.printNewLine();
        List<Integer> winningNumbers = InputView.inputWinningNumbers();

        OutputView.printNewLine();
        int bonusNumber = InputView.inputBonusNumber(winningNumbers);

    }
}
