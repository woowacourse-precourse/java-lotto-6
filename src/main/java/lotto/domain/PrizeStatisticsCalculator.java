package lotto.domain;

import java.util.List;
import java.util.function.BiFunction;

public enum PrizeStatisticsCalculator {
    THREE_MATCH(3, "3개 일치 (5,000원) - ", 5000, (lottoList, winningLotto) -> countMatches(lottoList, winningLotto, 3)),
    FOUR_MATCH(4, "4개 일치 (50,000원) - ", 50000, (lottoList, winningLotto) -> countMatches(lottoList, winningLotto, 4)),
    FIVE_MATCH(5, "5개 일치 (1,500,000원) - ", 1500000,
            (lottoList, winningLotto) -> countMatches(lottoList, winningLotto, 5)),
    FIVE_AND_BONUS_MATCH(5, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000,
            (lottoList, winningLotto) -> countMatchesWithBonus(lottoList, winningLotto, 5)),
    SIX_STRIKE(6, "6개 일치 (2,000,000,000원) - ", 2000000000,
            (lottoList, winningLotto) -> countMatches(lottoList, winningLotto, 6)),
    ;

    private final int matchCount;
    private final String message;
    private final long prizeMoney;
    private final BiFunction<List<Lotto>, Lotto, Long> countFunction;

    PrizeStatisticsCalculator(int matchCount, String message, long prizeMoney,
                              BiFunction<List<Lotto>, Lotto, Long> countFunction) {
        this.matchCount = matchCount;
        this.message = message;
        this.prizeMoney = prizeMoney;
        this.countFunction = countFunction;
    }

    private static long countMatches(List<Lotto> lottoList, Lotto winningLotto, int matchCount) {
        return lottoList.stream()
                .filter(boughtLotto -> boughtLotto.matchNumbers(winningLotto) == matchCount)
                .count();
    }

    public static long countMatchesWithBonus(List<Lotto> lottoList, Lotto winningLotto, int matchCount) {
        return lottoList.stream()
                .filter(boughtLotto -> boughtLotto.matchNumbers(winningLotto) == matchCount)
                .filter(boughtLotto -> boughtLotto.getBonusNumber() == winningLotto.getBonusNumber())
                .count();
    }

    public long getMatchCount(List<Lotto> lottoList, Lotto winningLotto) {
        return countFunction.apply(lottoList, winningLotto);
    }

    public void printMatchCount(List<Lotto> lottoList, Lotto winningLotto) {
        long matchCount = getMatchCount(lottoList, winningLotto);

        System.out.println(message + matchCount + "개");
    }

    public long calculateTotalProfit(List<Lotto> lottoList, Lotto winningLotto) {
        long matchCount = getMatchCount(lottoList, winningLotto);
        return matchCount * prizeMoney;
    }

    public long getPrizeMoney() {
        return this.prizeMoney;
    }
}
