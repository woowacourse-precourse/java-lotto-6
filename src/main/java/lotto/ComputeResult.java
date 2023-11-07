package lotto;

import java.util.List;

public class ComputeResult {
    public int computeTotal(List<Integer> win_counts) {
        return 5000 * win_counts.get(0)
                + 50000 * win_counts.get(1)
                + 1500000 * win_counts.get(2)
                + 30000000 * win_counts.get(3)
                + 2000000000 * win_counts.get(4);
    }
}
