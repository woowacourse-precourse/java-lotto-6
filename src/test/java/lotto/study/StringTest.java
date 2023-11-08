package lotto.study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("String.format()을 학습하기 위한 테스트이다.")
public class StringTest {

    @DisplayName("소수점 두 번째 자리까지 자를 수 있다.")
    @Test
    void splitSecondDecimalPlace() {
        // given
        double value = 100.1234;

        // when
        String result = String.format("%.1f", value);

        // then
        assertThat(result).isEqualTo("100.1");
    }

    @DisplayName("소수점 두 번째 자리에서 반올림할 수 있다.")
    @Test
    void roundSecondDecimalPlace() {
        // given
        double value = 100.1999;

        // when
        String result = String.format("%.1f", value);

        // then
        assertThat(result).isEqualTo("100.2");
    }
}
