package lotto.core.policy;

import java.util.List;

public interface WinningPolicy {
    Integer winningCount(List<Integer> lotto, List<Integer> winning);

    Boolean hitBonus(List<Integer> lotto, Integer bonus);
}
