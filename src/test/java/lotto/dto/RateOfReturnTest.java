package lotto.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.DecimalFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateOfReturnTest {

    @DisplayName("수익률을 적절한 문자열 형태로 변환한다.")
    @Test
    void toStringTest() {
        // given
        double given = 1_000_000.5;
        RateOfReturn rateOfReturn = new RateOfReturn(given);
        String expected = new DecimalFormat("#,###.0").format(given);

        // when
        String result = rateOfReturn.toString();

        // then
        assertThat(result).contains("총 수익률은")
                .contains("%입니다.")
                .contains(expected);
    }
}
