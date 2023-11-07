package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoFinalResultTest {
    @Test
    void FIVE_추가하면_FIVE_Value_1_추가() {
        LottoFinalResult lottoFinalResult = new LottoFinalResult();
        lottoFinalResult.addLottoResult(LottoResult.FIVE);

        Integer lottoResultCount = lottoFinalResult.getFinalResultMap().get(LottoResult.FIVE);
        assertThat(lottoResultCount).isEqualTo(1);
    }

    private static Stream<Arguments> checkLottoResultAndReturn() {
        return Stream.of(
                Arguments.of(LottoResult.FIVE, LottoResult.FIVE.getWinningAmount()),
                Arguments.of(LottoResult.FOUR, LottoResult.FOUR.getWinningAmount()),
                Arguments.of(LottoResult.THREE, LottoResult.THREE.getWinningAmount())
        );
    }

    @ParameterizedTest(name = "LottResult : {0} 수익 : {1}")
    @MethodSource("checkLottoResultAndReturn")
    void 최종_수익_검증(LottoResult lottoResult, int result) {
        LottoFinalResult lottoFinalResult = new LottoFinalResult();
        lottoFinalResult.addLottoResult(lottoResult);

        int calculatedResult = lottoFinalResult.calculateReturn();

        assertThat(calculatedResult).isEqualTo(result);
    }
}
