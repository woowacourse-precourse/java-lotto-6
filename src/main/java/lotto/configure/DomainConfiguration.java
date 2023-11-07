package lotto.configure;

import java.util.Map;

/**
 * 도메인에 관련된 상수를 정의한 클래스
 */
public class DomainConfiguration {

    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;
    public static final int LENGTH_OF_LOTTO = 6;
    public static final int PRICE_OF_LOTTO = 1000;
    public static final int RANGE_OF_RANK = 5;
    public static final Map<Integer, Integer> RANK_PER_NUM_OF_MATCHES = Map.of(
            6, 1,
            5, 2,
            4, 4,
            3, 5
    );
    public static final int RANK_FOR_CHECK_BONUS_NUMBER = 2;
    public static final Map<Integer, Integer> REWARD_PER_RANK = Map.of(
            1, 2000000000,
            2, 30000000,
            3, 1500000,
            4, 50000,
            5, 5000
    );
}
