package lotto.model.data;

import java.util.Comparator;
import java.util.List;
import lotto.model.generator.LottoNumberGenerator;
import lotto.model.record.BonusNumber;

public class GameNumberFactory {
    private final Lottos lottos = new Lottos();
    private AnswerNumbers answerNumber;

    public List<Lotto> quickPickOrSlip(Integer amountOfLotto, LottoNumberGenerator lottoNumberGenerator,
                                       Comparator<Integer> order) {
        for (int idx = 0; idx < amountOfLotto; idx++) {
            lottos.buyLotto(lottoNumberGenerator.drawLots(order));
        }

        return lottos.purchasedLotto();
    }

    public void saveWinningNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
        answerNumber = new AnswerNumbers(new WinningNumbers(winningNumbers), new BonusNumber(bonusNumber));
    }

    public WinningStatus calculateWinningStatus() {
        return lottos.compareWithAnswerNumbers(answerNumber);
    }
}
