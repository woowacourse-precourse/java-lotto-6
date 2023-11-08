package lotto.domain;

public interface LotteryRanking {
    boolean matches(int counts, boolean isBonusNumberMatch);

    int getAmount();

    int getMatches();

    String getName();
}
