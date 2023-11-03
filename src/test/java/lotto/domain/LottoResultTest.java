package lotto.domain;

import static lotto.constants.LottoPrize.FIFTH_PRIZE;
import static lotto.constants.LottoPrize.FIRST_PRIZE;
import static lotto.constants.LottoPrize.FOURTH_PRIZE;
import static lotto.constants.LottoPrize.NO_PRIZE;
import static lotto.constants.LottoPrize.THIRD_PRIZE;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;
import lotto.constants.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultTest {

    @ParameterizedTest
    @DisplayName("로또 결과에 정보 저장 및 당첨 카운트와 당첨 결과 수익 확인")
    @MethodSource("initResultLottoData")
    void lottoResultTest(List<LottoPrize> lottoResults
            , int consumerAmount
            , List<Integer> prizeResults
            , BigDecimal profitRate
    ) {
        LottoResult lottoResult = new LottoResult(lottoResults, consumerAmount);

        // 당첨 결과 카운팅 정보 일치 확인
        assertThat(lottoResult.getLottoWinningCounts()).isEqualTo(prizeResults);
        // 당첨 결과 수익률 일치 확인
        assertThat(lottoResult.getProfitRate().compareTo(profitRate)).isEqualTo(0);
    }

    static Stream<Arguments> initResultLottoData() {
        return Stream.of(
                Arguments.of(List.of(NO_PRIZE, FIFTH_PRIZE, NO_PRIZE, NO_PRIZE, NO_PRIZE, NO_PRIZE, NO_PRIZE, NO_PRIZE)
                        , 8000
                        , List.of(0, 0, 0, 0, 1)
                        , new BigDecimal(62.5)),
                Arguments.of(List.of(NO_PRIZE, FIRST_PRIZE)
                        , 2000
                        , List.of(1, 0, 0, 0, 0)
                        , new BigDecimal(100000000)),
                Arguments.of(List.of(FIFTH_PRIZE, FIFTH_PRIZE, FOURTH_PRIZE, THIRD_PRIZE)
                        , 4000
                        , List.of(0, 0, 1, 1, 2)
                        , new BigDecimal(39000))
        );
    }
}