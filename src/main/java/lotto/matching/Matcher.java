package lotto.matching;

import java.util.List;
import lotto.Grade;
import lotto.Lotto;
import lotto.result.Result;

public class Matcher {

    public Result matchWinning(Lotto winningLotto, List<Lotto> lottoList, int bonus) {
        Result result = new Result();

        lottoList.forEach(lotto -> {
            long count = lotto.getNumbers().stream()
                    .filter(winningLotto.getNumbers()::contains)
                    .count();
            boolean isBonusMatched = lotto.getNumbers().contains(bonus);
            Grade grade = Grade.of((int) count, isBonusMatched);

            result.addResult(grade);
        });

        return result;
    }
}
