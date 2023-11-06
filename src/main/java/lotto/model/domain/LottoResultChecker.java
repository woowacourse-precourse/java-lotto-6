package lotto.model.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoResultChecker {
    private final List<Lotto> issuedLotto;
    private final WinningLotto winningLotto;
    private final Bonus bonus;

    public LottoResultChecker(List<Lotto> issuedLotto, WinningLotto winningLotto, Bonus bonus) {
        this.issuedLotto = issuedLotto;
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    public List<Ranking> checkResult() {
        List<Ranking> results = new ArrayList<>();
        for(Lotto lotto : issuedLotto) {
            List<Integer> issuedNumbers = lotto.getNumbers();
            boolean isMatchedBonusNumber = issuedNumbers.contains(bonus.getNumber());
            issuedNumbers.retainAll(winningLotto.getNumbers());
            Result result = new Result(issuedNumbers.size(), isMatchedBonusNumber);
            Ranking rankingOfLotto = result.checkRanking();
            //TODO: null이 들어왔을 때 처리할 방법도 고안해야 한다.
            results.add(rankingOfLotto);
        }
        return results;
    }

}
