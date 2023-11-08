package lotto.domain.constant;

import lotto.domain.money.Money;

public class RankingConstant {

    public static final int FIRST_RANKING_NUMBER_OF_MATCHES = 6;
    public static final int SECOND_RANKING_NUMBER_OF_MATCHES = 5;
    public static final int THIRD_RANKING_NUMBER_OF_MATCHES = 5;
    public static final int FOURTH_RANKING_NUMBER_OF_MATCHES = 4;
    public static final int FIFTH_RANKING_NUMBER_OF_MATCHES = 3;
    public static final int UNRANKED_NUMBER_OF_MATCHES_LIMIT = 2;

    public static final Money FIRST_RANKING_PRIZE = Money.valueOf(2_000_000_000);
    public static final Money SECOND_RANKING_PRIZE = Money.valueOf(30_000_000);
    public static final Money THIRD_RANKING_PRIZE = Money.valueOf(1_500_000);
    public static final Money FOURTH_RANKING_PRIZE = Money.valueOf(50_000);
    public static final Money FIFTH_RANKING_PRIZE = Money.valueOf(5_000);
    public static final Money UNRANKED_PRIZE = Money.valueOf(0);

    private RankingConstant() {
    }
}
