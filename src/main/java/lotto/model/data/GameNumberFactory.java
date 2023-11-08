package lotto.model.data;

import java.util.List;
import lotto.model.generator.LottoNumberGenerator;
import lotto.model.record.BonusNumber;

public class GameNumberFactory {
    private Lottos lottos;
    private AnswerNumbers answerNumber;

    public List<Lotto> quickPickOrSlip(Integer amountOfLotto, LottoNumberGenerator lottoNumberGenerator) {
        lottos = new Lottos();

        for (int idx = 1; idx <= amountOfLotto; idx++) {
            lottos.buyLotto(lottoNumberGenerator.drawLots());
        }
        return lottos.purchasedLotto();
    }

    public AnswerNumbers createWinningNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
        answerNumber = new AnswerNumbers(new WinningNumbers(winningNumbers), new BonusNumber(bonusNumber));

        return answerNumber;
    }

    public WinningStatus compareLottosAndAnswerNumbers() {
        WinningStatus winningStatus = new WinningStatus();

        for (Lotto purchasedLotto : lottos.purchasedLotto()) {
            int countOfMatchedWinningNumber = purchasedLotto.compareLottoAndWinningNumbers(
                    answerNumber.getWinningNumbers());
            int countOfMatchedBonusNumber = purchasedLotto.compareLottoAndBonusNumber(answerNumber.getBonusNumber());

            winningStatus.winning(countOfMatchedWinningNumber, countOfMatchedBonusNumber);
        }

        return winningStatus;
    }
}
