package lotto.constants;

import java.util.Map;
import lotto.domain.LottoMatchType;

public class IntegerConstants {
    public final static int LOTTO_PRICE = 1000;
    public final static int LOTTO_RANGE_START = 1;
    public final static int LOTTO_RANGE_END = 45;
    public final static int LOTTO_NUMBERS_COUNT = 6;
    public final static long MATCH_THREE = 3;
    public final static long MATCH_FOUR = 4;
    public final static long MATCH_FIVE = 5;
    public final static long MATCH_SIX = 6;

    public final static Map<LottoMatchType, Long> MATCH_TYPE_TO_NUMBER_MAP = Map.ofEntries(
            Map.entry(LottoMatchType.MATCH_THREE, MATCH_THREE),
            Map.entry(LottoMatchType.MATCH_FOUR, MATCH_FOUR),
            Map.entry(LottoMatchType.MATCH_FIVE, MATCH_FIVE),
            Map.entry(LottoMatchType.MATCH_FIVE_BONUS, MATCH_FIVE),
            Map.entry(LottoMatchType.MATCH_SIX, MATCH_SIX)
    );

    public final static long MATCH_NONE_REWARD = 0;
    public final static long MATCH_THREE_REWARD = 5000;
    public final static long MATCH_FOUR_REWARD = 50000;
    public final static long MATCH_FIVE_REWARD = 1500000;
    public final static long MATCH_FIVE_BONUS_REWARD = 30000000;
    public final static long MATCH_SIX_REWARD = 2000000000;

    public final static Map<LottoMatchType, Long> MATCH_TYPE_TO_REWARD_MAP = Map.ofEntries(
            Map.entry(LottoMatchType.MATCH_NONE, MATCH_NONE_REWARD),
            Map.entry(LottoMatchType.MATCH_THREE, MATCH_THREE_REWARD),
            Map.entry(LottoMatchType.MATCH_FOUR, MATCH_FOUR_REWARD),
            Map.entry(LottoMatchType.MATCH_FIVE, MATCH_FIVE_REWARD),
            Map.entry(LottoMatchType.MATCH_FIVE_BONUS, MATCH_FIVE_BONUS_REWARD),
            Map.entry(LottoMatchType.MATCH_SIX, MATCH_SIX_REWARD)
    );
}
