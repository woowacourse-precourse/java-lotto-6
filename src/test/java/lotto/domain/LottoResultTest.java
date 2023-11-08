package lotto.domain;

import static common.enumtype.ResultType.FIFTH_PLACE;
import static common.enumtype.ResultType.FIRST_PLACE;
import static common.enumtype.ResultType.FOURTH_PLACE;
import static common.enumtype.ResultType.SECOND_PLACE;
import static common.enumtype.ResultType.THIRD_PLACE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import common.enumtype.ResultType;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 당첨 결과 검증")
class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        List<ResultType> resultTypes = List.of(FIFTH_PLACE, THIRD_PLACE);
        lottoResult = new LottoResult(resultTypes);
    }

    @Test
    void 로또_당첨_결과_통계_검증() {
        // when
        Map<ResultType, Integer> result = lottoResult.getResult();

        // then
        assertAll(
                () -> assertThat(result.getOrDefault(FIFTH_PLACE, 0)).isEqualTo(1),
                () -> assertThat(result.getOrDefault(FOURTH_PLACE, 0)).isEqualTo(0),
                () -> assertThat(result.getOrDefault(THIRD_PLACE, 0)).isEqualTo(1),
                () -> assertThat(result.getOrDefault(SECOND_PLACE, 0)).isEqualTo(0),
                () -> assertThat(result.getOrDefault(FIRST_PLACE, 0)).isEqualTo(0)
        );
    }

    @Test
    void 로또_결과_수익률_검증() {
        // given
        int amount = 8000;

        // when
        double result = lottoResult.getYieldRate(amount);

        // then
        assertThat(result).isEqualTo(18812.5);
    }
}
