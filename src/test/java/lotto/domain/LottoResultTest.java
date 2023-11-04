package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @ParameterizedTest
    @MethodSource("parameter")
    @DisplayName("수익률이 정상적으로 출력되어야 한다.")
    void 로또_당첨_결과(Map<LottoRankInfo, Integer> rank) {
        //given
        LottoResult result = new LottoResult(rank);
        //when
        String ratio = result.getReturnRatio();
        //then
        assertThat(ratio).contains(getRatio(rank, 8000L));
    }

    static Stream<Arguments> parameter() {
        return Stream.of(
                Arguments.of(
                        Map.ofEntries(
                                Map.entry(LottoRankInfo.FIFTH, 7),
                                Map.entry(LottoRankInfo.NONE, 1))),
                Arguments.of(
                        Map.ofEntries(
                                Map.entry(LottoRankInfo.SECOND, 5),
                                Map.entry(LottoRankInfo.NONE, 3))),
                Arguments.of(
                        Map.ofEntries(
                                Map.entry(LottoRankInfo.FIRST, 3),
                                Map.entry(LottoRankInfo.NONE, 5))),
                Arguments.of(
                        Map.ofEntries(
                                Map.entry(LottoRankInfo.FIFTH, 1),
                                Map.entry(LottoRankInfo.NONE, 7)))
        );
    }

    String getRatio(Map<LottoRankInfo, Integer> rank, Long pay) {
        Long winningPrice = rank.entrySet()
                .stream()
                .map(e -> e.getKey().getRewardPrice() * e.getValue())
                .reduce(0L, Long::sum);

        DecimalFormat df = new DecimalFormat("#.##%");
        double result = winningPrice / (double) pay;
        return df.format(result);
    }
}