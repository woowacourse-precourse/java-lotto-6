package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {
    Map<Rank, Integer> result = new HashMap<>();
    LottosResult lottosResult = new LottosResult();
    private static final int FIRST_PRIZE = 2_000_000_000;
    private static final int SECOND_PRIZE = 30_000_000;
    private static final int THIRD_PRIZE = 1_500_000;
    @DisplayName("구입한 로또들에 대한 총 상금을 알 수 있다.")
    @Test
    void checkTotalPrize() {
        result.put(Rank.FIRST,1);
        result.put(Rank.SECOND,1);
        result.put(Rank.THIRD,2);
        int totalPrize = FIRST_PRIZE + SECOND_PRIZE + (THIRD_PRIZE * 2);
        Assertions.assertThat(lottosResult.calculateTotalPrize(result)).isEqualTo(totalPrize);
    }

}
