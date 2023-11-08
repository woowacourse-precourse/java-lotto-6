package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LottoResult {
    ZERO(0, 0, "0개 일치"),
    ONE(1, 0, "1개 일치"),
    TWO(2, 0, "2개 일치"),
    THREE(3, 5000, "3개 일치"),
    FOUR(4, 50000, "4개 일치"),
    FIVE(5, 1500000, "5개 일치"),
    FIVE_AND_BONUS(7, 30000000, "5개 일치, 보너스 볼 일치"), // 특별 추가 사항.. 이게 옳은 방법인지는 모르겠다?
    SIX(6, 2000000000, "6개 일치")
    ;

    private final int sameNumberCount;
    private final int winningAmount;
    private final String description;

    private static Map<Integer, LottoResult> lottoResultMap = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(LottoResult::getSameNumberCount, Function.identity()))
    );

    public static LottoResult findLottoResultBySameNumberCount(int sameNumberCount) {
        return lottoResultMap.get(sameNumberCount);
    }

    LottoResult(int sameNumberCount, int winningAmount, String description) {
        this.sameNumberCount = sameNumberCount;
        this.winningAmount = winningAmount;
        this.description = description;
    }

    public int getSameNumberCount() {
        return sameNumberCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public String getDescription() {
        return description;
    }
}
