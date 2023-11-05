package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LottoResult {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_AND_BONUS(7, 30000000), // 특별 추가 사항.. 이게 옳은 방법인지는 모르겠다?
    SIX(6, 2000000000)
    ;

    private final int sameNumberCount;
    private final int winningAmount;

    private static Map<Integer, Integer> lottoResultMap = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(LottoResult::getSameNumberCount, LottoResult::getWinningAmount))
    );

    private static int findLottoResultBySameNumberCount(int sameNumberCount) {
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
