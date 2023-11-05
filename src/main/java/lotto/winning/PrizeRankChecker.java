package lotto.winning;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class PrizeRankChecker {

    public List<Integer> computeMatchedNumberCounts(List<Lotto> lottos, List<Integer> Numbers) {
        List<Integer> matchedNumberCounts = new ArrayList<>();

        for (Lotto lotto : lottos) {
            matchedNumberCounts.add(calculateNumberMatch(lotto.getNumbers(), Numbers));
        }

        return matchedNumberCounts;
    }

    private int calculateNumberMatch(List<Integer> lotto, List<Integer> numbers) {
        return (int) lotto.stream()
                .filter(numbers::contains)
                .count();
    }
}
