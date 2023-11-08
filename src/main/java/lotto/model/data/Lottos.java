package lotto.model.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public void buyLotto(List<Integer> lotto) {
        lottos.add(new Lotto(lotto));
    }

    public List<Lotto> purchasedLotto() {
        return Collections.unmodifiableList(lottos);
    }

    public WinningStatus compareWithAnswerNumbers(AnswerNumbers answerNumbers) {
        WinningStatus winningStatus = new WinningStatus();

        for (Lotto lotto : lottos) {
            int countOfMatchedWinningNumber = lotto.compareLottoAndWinningNumbers(
                    answerNumbers.getWinningNumbers());
            int countOfMatchedBonusNumber = lotto.compareLottoAndBonusNumber(answerNumbers.getBonusNumber());

            winningStatus.recordWinning(countOfMatchedWinningNumber, countOfMatchedBonusNumber);
        }

        return winningStatus;
    }
}
