package lotto.service;

import lotto.domain.LottoMachine;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoWinningNumber;
import lotto.view.LottoGameInput;
import lotto.view.LottoGameOutput;

import java.util.List;

public class LottoGameService {

    private LottoMachine lottoMachine;
    private LottoWinningNumber lottoWinningNumber;
    private LottoStatistics lottoStatistics;

    public void play() {
        inputPurchaseAmount();

        LottoGameOutput.printPurchaseLottos(lottoMachine.getLottos());

        inputWinningNumbers();

        // ---
        lottoStatistics = new LottoStatistics(lottoMachine, lottoWinningNumber);
        LottoGameOutput.printWinningStatistics(lottoStatistics);

        // ---
    }

    private void inputWinningNumbers() {
        List<Integer> winningNumbers = LottoGameInput.readWinningNumbers();
        int bonusNumber = LottoGameInput.readBonusNumber();
        lottoWinningNumber = new LottoWinningNumber(winningNumbers, bonusNumber);
    }

    private void inputPurchaseAmount() {
        int purchaseAmount = LottoGameInput.readPurchaseAmount();
        lottoMachine = new LottoMachine(purchaseAmount);
    }
}
