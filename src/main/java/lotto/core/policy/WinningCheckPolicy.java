package lotto.core.policy;

import java.util.List;

public class WinningCheckPolicy implements WinningPolicy {

    @Override
    public Integer winningCount(List<Integer> lotto, List<Integer> winning, Integer bonus) {
        return lotto.stream()
                .filter(number -> winning.contains(number) || number.equals(bonus))
                .toList()
                .size();
    }
}
