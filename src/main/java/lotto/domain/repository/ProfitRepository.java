package lotto.domain.repository;

import java.util.LinkedList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Profit;

public class ProfitRepository {
    private static final int DEFAULT = 0;

    private static List<Profit> profits = new LinkedList<>();

    public static void add(Profit profit) {
        profits.add(profit);
    }

    public static double findProfitRate() {
        return findByIndex(DEFAULT).getRate();
    }

    private static Profit findByIndex(int index) {
        return profits.get(index);
    }
}
