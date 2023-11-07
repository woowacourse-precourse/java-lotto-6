package lotto.domain;

import lotto.config.WinningPrize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private static LottoResult result;

    @BeforeEach
    void resultSetup() {
        result = new LottoResult();

        for (int i = 0; i < 1; i++) {
            result.apply(WinningPrize.SECOND_PLACE);
        }
        for (int i = 0; i < 2; i++) {
            result.apply(WinningPrize.THIRD_PLACE);
        }
        for (int i = 0; i < 3; i++) {
            result.apply(WinningPrize.FOURTH_PLACE);
        }
        for (int i = 0; i < 4; i++) {
            result.apply(WinningPrize.FIFTH_PLACE);
        }
        for (int i = 0; i < 90; i++) {
            result.apply(null);
        }
    }

    @DisplayName("각 결과 확인")
    @ParameterizedTest
    @MethodSource("eachResult")
    void checkEachResult(WinningPrize prize, int count) {
        assertThat(result.getEachResult(prize)).isEqualTo(count);
    }

    @DisplayName("수익률 확인")
    @Test
    void checkFinalProfit() {
        assertThat(result.getFinalProfit()).isEqualTo(33170.0F);
    }

    static Stream<Arguments> eachResult() {
        return Stream.of(
                Arguments.of(WinningPrize.FIRST_PLACE, 0),
                Arguments.of(WinningPrize.SECOND_PLACE, 1),
                Arguments.of(WinningPrize.THIRD_PLACE, 2),
                Arguments.of(WinningPrize.FOURTH_PLACE, 3),
                Arguments.of(WinningPrize.FIFTH_PLACE, 4)
        );
    }
}
