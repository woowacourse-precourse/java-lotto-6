package lotto.domain.answer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import lotto.domain.Lotto;
import lotto.domain.User;

public class LottoAnswer {
    private final Lotto answer;

    private final Integer bonus;

    public LottoAnswer(Lotto answer, Integer bonus) {
        this.answer = answer;
        this.bonus = bonus;
    }

    public int getAnswerSize() {
        return answer.getSize();
    }

    public Map<Integer, Integer> getRankToCount(BiFunction<Integer, Boolean, Integer> rankPolicy, User user) {
        Map<Integer, Integer> rankToCount = new HashMap<>();
        user.getLottos().forEach(lotto -> {
            int count = lotto.getMatchNumberCount(answer);
            boolean hasBonusNumber = lotto.hasBonusNumber(bonus);
            int rank = rankPolicy.apply(count, hasBonusNumber);
            rankToCount.put(rank, rankToCount.getOrDefault(rank, 0) + 1);
        });
        return rankToCount;
    }
}
