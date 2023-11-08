package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    private static final int FIRST_PRIZE = 2_000_000_000;
    private static final int SECOND_PRIZE = 30_000_000;
    private static final int THIRD_PRIZE = 1_500_000;

    private Map<Rank, Integer> result = new HashMap<>();
    private final LottosResult lottosResult = new LottosResult();

    @DisplayName("구입한 로또들에 대한 총 상금을 알 수 있다.")
    @Test
    void checkTotalPrize() {
        int totalPrize = FIRST_PRIZE + SECOND_PRIZE + (THIRD_PRIZE * 2);
        Assertions.assertThat(lottosResult.calculateTotalPrize(result)).isEqualTo(totalPrize);
    }

    @DisplayName("로또들의 결과에 대한 등수가 몇 개씩 존재하는지 확인한다.")
    @Test
    void checkEachRankCount() {
        List<Integer> expectationCount = List.of(0, 0, 2, 1, 1);

        Assertions.assertThat(lottosResult.countEachRank(result)).isEqualTo(expectationCount);
    }

    @BeforeEach
    void initializeResult() {
        result = Map.of(
                Rank.FIRST, 1,
                Rank.SECOND, 1,
                Rank.THIRD, 2
        );
    }
}
