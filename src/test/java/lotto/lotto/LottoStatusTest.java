package lotto.lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoStatusTest {
    @DisplayName("정상 동작 테스트")
    @ParameterizedTest
    @MethodSource("okParameter")
    void ok(int buyCount, List<LottoResult> lottoResults, double expectedReturnRate) {
        LottoStatus lottoStatus = new LottoStatus(buyCount);
        lottoResults.forEach(lottoStatus::insert);
        Map<LottoResult, Integer> lottoResultCounts = new HashMap<>();
        lottoResults.forEach(lottoResult -> {
            int count = lottoResultCounts.getOrDefault(lottoResult, 0);
            lottoResultCounts.put(lottoResult, count + 1);
        });
        Assertions.assertThat(lottoStatus.isLogicallyEqual(lottoResultCounts)).isTrue();
        Assertions.assertThat(lottoStatus.isReturnRateEqualsTo(expectedReturnRate)).isTrue();
    }

    static Stream<Arguments> okParameter() {
        return Stream.of(
                Arguments.of(1000, List.of(LottoResult.FIFTH_PRIZE), 500.0),
                Arguments.of(2000, List.of(LottoResult.SECOND_PRIZE), 1500000.0),
                Arguments.of(400000, List.of(LottoResult.FIRST_PRIZE, LottoResult.SECOND_PRIZE), 507500.0),
                Arguments.of(6000, List.of(LottoResult.values()), 33859250.0)
        );
    }
}