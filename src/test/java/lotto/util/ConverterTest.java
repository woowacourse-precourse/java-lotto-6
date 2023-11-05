package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConverterTest {
    @Test
    @DisplayName("입력 받은 문자열을 int형으로 잘 변환해주는지 확인한다.")
    void convertStringToInt() {
        String inputString = "1";

        assertThat(Converter.stringToInt(inputString)).isEqualTo(1);
    }

    @Test
    @DisplayName("형변환이 안되는 문자열 입력 시 예외 발생한다.")
    void convertExceptionOnInvalidInput() {
        assertThatThrownBy(() -> Converter.stringToInt("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자를 입력해주세요.");
    }

}
