package lotto.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.ResultLotto;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;

public class ResultManager {
    public List<ResultLotto> match(WinningLotto winningLotto, UserLotto userLotto, BonusNumber bonusNumber) {
        List<ResultLotto> resultLotto = new ArrayList<>();
        for (int i = 0; i < userLotto.size(); i++) {
            Lotto eachLotto = userLotto.get(i);
            int match = winningLotto.grade(eachLotto);
            resultLotto.add(ResultLotto.getOrdinal(match));
        }
        bonusMatch(userLotto, bonusNumber, resultLotto);
        return resultLotto;
    }

    private void bonusMatch(UserLotto userLotto, BonusNumber bonusNumber, List<ResultLotto> resultLotto) {
        Stream.iterate(0, i -> i + 1)
                .limit(resultLotto.size())
                .filter(i -> resultLotto.get(i).equals(ResultLotto.FIVE))
                .filter(i -> userLotto.get(i).contains(bonusNumber.getBonusNumber()))
                .forEach(i -> resultLotto.set(i, ResultLotto.FIVE_BONUS));
    }
}
