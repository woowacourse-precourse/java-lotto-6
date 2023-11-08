package lotto.study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("둘째 자리가 5이상이면 올림한다.")
    void 올림() {
        // given
        double value = 34.153;

        // when
        String result = String.format("%.1f", value);

        // then
        assertThat(result).isEqualTo("34.2");
    }

    @Test
    @DisplayName("둘째 자리가 5미만이면 올림한다.")
    void 내림() {
        // given
        double value = 34.143;

        // when
        String result = String.format("%.1f", value);

        // then
        assertThat(result).isEqualTo("34.1");
    }
}
