package lotto.domain;

import static lotto.utils.StringUtils.numbersToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Results {

    private static List<Lotto> lottos;
    private static Winning winning;
    private static Bonus bonus;
    private static List<Rank> results;
    private static Map<Rank, Long> resultCount;

    public Results(List<Lotto> lottos, Winning winning, Bonus bonus) {
        Results.lottos = lottos;
        Results.winning = winning;
        Results.bonus = bonus;
        Results.results = new ArrayList<>();
    }

    public static Results of(List<Lotto> lottos, Winning winning, Bonus bonus) {
        return new Results(lottos, winning, bonus);
    }

    public String makeResultToString() {
        makeResults();

        return "\n당첨 통계\n"
                + "---\n"
                + "3개 일치 (" + numbersToString(Rank.FIFTH.getPrize()) + "원) - " + resultCount.get(Rank.FIFTH) + "개\n"
                + "4개 일치 (" + numbersToString(Rank.FOURTH.getPrize()) + "원) - " + resultCount.get(Rank.FOURTH) + "개\n"
                + "5개 일치 (" + numbersToString(Rank.THIRD.getPrize()) + "원) - " + resultCount.get(Rank.THIRD) + "개\n"
                + "5개 일치, 보너스 볼 일치 (" + numbersToString(Rank.SECOND.getPrize()) + "원) - " + resultCount.get(Rank.SECOND) + "개\n"
                + "6개 일치 (" + numbersToString(Rank.FIRST.getPrize()) + "원) - " + resultCount.get(Rank.FIRST) + "개\n";
    }

    private void makeResults() {
        for (Lotto lotto : lottos) {
            Results.results.add(lotto.checkResult(winning, bonus));
        }

        resultCount = Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.MISS)
                .collect(Collectors.toMap(rank -> rank, rank -> results.stream().filter(r -> r == rank).count()));
    }
}
