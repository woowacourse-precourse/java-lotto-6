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
    public Boolean hitBonus(List<Integer> lotto, Integer bonus) {
        return lotto.contains(bonus);
    }
}
