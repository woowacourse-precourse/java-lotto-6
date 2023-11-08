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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 당첨 결과 검증")
class LottoResultTest {

    @Test
    void 로또_당첨_결과_통계_검증() {
        // given
        List<ResultType> resultTypes = List.of(
                FIFTH_PLACE, FIFTH_PLACE,
                FOURTH_PLACE, FOURTH_PLACE, FOURTH_PLACE,
                THIRD_PLACE,
                SECOND_PLACE, SECOND_PLACE,
                FIRST_PLACE
        );
        LottoResult lottoResult = new LottoResult(resultTypes);

        // when
        Map<ResultType, Integer> result = lottoResult.getResult();

        // then
        assertAll(
                () -> assertThat(result.getOrDefault(FIFTH_PLACE, 0)).isEqualTo(2),
                () -> assertThat(result.getOrDefault(FOURTH_PLACE, 0)).isEqualTo(3),
                () -> assertThat(result.getOrDefault(THIRD_PLACE, 0)).isEqualTo(1),
                () -> assertThat(result.getOrDefault(SECOND_PLACE, 0)).isEqualTo(2),
                () -> assertThat(result.getOrDefault(FIRST_PLACE, 0)).isEqualTo(1)
        );
    }
}
