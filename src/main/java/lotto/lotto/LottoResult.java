package lotto.lotto;

import static lotto.error.message.InvalidStateErrorMessage.LOTTO_RESULT_STATE_ERROR;
import static lotto.error.message.InvalidStateErrorMessage.UNKNOWN_ERROR_MESSAGE;
import static lotto.global.Constant.LOTTO_BEST_RANK;
import static lotto.global.Constant.LOTTO_WORST_RANK;

import java.util.HashMap;
import java.util.Map;
import lotto.error.exception.InvalidStateException;

public class LottoResult {
    private static final Map<Integer, Long> PRIZE_MAP = new HashMap<>();
    private static final Map<Integer, Integer> MATCH_NUMBERS_COUNT_MAP = new HashMap<>();
    static {
        PRIZE_MAP.put(1, 2000000000L);
        PRIZE_MAP.put(2, 30000000L);
        PRIZE_MAP.put(3, 1500000L);
        PRIZE_MAP.put(4, 50000L);
        PRIZE_MAP.put(5, 5000L);
        PRIZE_MAP.put(0, 0L);
        MATCH_NUMBERS_COUNT_MAP.put(1, 6);
        MATCH_NUMBERS_COUNT_MAP.put(2, 5);
        MATCH_NUMBERS_COUNT_MAP.put(3, 5);
        MATCH_NUMBERS_COUNT_MAP.put(4, 4);
        MATCH_NUMBERS_COUNT_MAP.put(5, 3);
        MATCH_NUMBERS_COUNT_MAP.put(0, 0);
    }

    private final Integer rank;
    private final Long prize;
    private final Integer matchNumbersCount;

    public LottoResult(int rank) {
        this.rank = rank;
        validateRank();
        this.prize = PRIZE_MAP.get(rank);
        this.matchNumbersCount = MATCH_NUMBERS_COUNT_MAP.get(rank);
        validateResultMap();
    }

    public int getRank() {
        return rank;
    }

    public long getPrize() {
        return prize;
    }

    public long getMatchNumbersCount() {
        return matchNumbersCount;
    }

    private void validateRank() {
        if (this.rank < LOTTO_BEST_RANK.getNumber() - 1 || this.rank > LOTTO_WORST_RANK.getNumber()) {
            throw new InvalidStateException(UNKNOWN_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateResultMap() {
        if (this.prize == null || this.matchNumbersCount == null) {
            throw new InvalidStateException(LOTTO_RESULT_STATE_ERROR.getMessage());
        }
    }
}
