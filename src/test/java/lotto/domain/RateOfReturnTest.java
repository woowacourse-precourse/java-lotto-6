package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("수익률 테스트")
class RateOfReturnTest {
    @ParameterizedTest(name = "[{index}] 백분율 변환 확인")
    @ValueSource(doubles = {0.25, 1, 0, 0.3548})
    void 백분율_변환_확인(Double num) {
        // when
        RateOfReturn rateOfReturn = new RateOfReturn(num);

        // then
        assertThat(rateOfReturn.getRateOfReturnPercentage()).isEqualTo(num * 100);
    }
}