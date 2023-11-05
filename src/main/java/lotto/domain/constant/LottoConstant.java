package lotto.domain.constant;

import lotto.domain.money.Money;

public class LottoConstant {

    public static final int LOTTO_MINIMUM_NUMBER = 1;
    public static final int LOTTO_MAXIMUM_NUMBER = 45;
    public static final int LOTTO_NUMBERS_SIZE = 6;

    public static final Money LOTTO_PRICE = Money.valueOf(1000);

    public static final int FIRST_RANKING_NUMBER_OF_MATCHES = 6;
    public static final int SECOND_RANKING_NUMBER_OF_MATCHES = 5;
    public static final int THIRD_RANKING_NUMBER_OF_MATCHES = 5;
    public static final int FOURTH_RANKING_NUMBER_OF_MATCHES = 4;
    public static final int FIFTH_RANKING_NUMBER_OF_MATCHES = 3;
    public static final int UNRANKED_NUMBER_OF_MATCHES_LIMIT = 2;

    public static final Money FIRST_RANKING_PRIZE = Money.valueOf(2000000000);
    public static final Money SECOND_RANKING_PRIZE = Money.valueOf(30000000);
    public static final Money THIRD_RANKING_PRIZE = Money.valueOf(1500000);
    public static final Money FOURTH_RANKING_PRIZE = Money.valueOf(50000);
    public static final Money FIFTH_RANKING_PRIZE = Money.valueOf(5000);
    public static final Money UNRANKED_PRIZE = Money.valueOf(0);

    private LottoConstant() {
    }
}
