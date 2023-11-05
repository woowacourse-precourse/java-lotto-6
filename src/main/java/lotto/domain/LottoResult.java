package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LottoResult {
    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_AND_BONUS(7, 30000000), // 특별 추가 사항.. 이게 옳은 방법인지는 모르겠다?
    SIX(6, 2000000000)
    ;

    private final int sameNumberCount;
    private final int winningAmount;

    private static Map<Integer, LottoResult> lottoResultMap = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(LottoResult::getSameNumberCount, Function.identity()))
    );

    public static LottoResult findLottoResultBySameNumberCount(int sameNumberCount) {
        return lottoResultMap.get(sameNumberCount);
    }

    LottoResult(int sameNumberCount, int winningAmount) {
        this.sameNumberCount = sameNumberCount;
        this.winningAmount = winningAmount;
    }

    public int getSameNumberCount() {
        return sameNumberCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
