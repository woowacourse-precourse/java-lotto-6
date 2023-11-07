package lotto.core.policy;

import java.util.List;

public class WinningCheckPolicy implements WinningPolicy {

    @Override
    public Integer winningCount(List<Integer> lotto, List<Integer> winning) {
        return lotto.stream()
                .filter(winning::contains)
                .toList()
                .size();
    }

    @Override
    public Integer hitBonus(List<Integer> lotto, Integer bonus) {
        if (lotto.contains(bonus)) {
            return 1;
        }
        return 0;
    }
}
