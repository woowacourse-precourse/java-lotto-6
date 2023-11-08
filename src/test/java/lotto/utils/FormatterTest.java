package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FormatterTest {

    @DisplayName("formatToDecimal 메소드 : 천 단위로 콤마 출력 테스트")
    @Test
    void formatToDecimal_resultTest() {
        int number = 1234567;
        String result = "1,234,567";
        assertThat(Formatter.formatToDecimal(number)).isEqualTo(result);
    }

}