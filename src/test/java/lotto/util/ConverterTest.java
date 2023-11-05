package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConverterTest {
    @Test
    @DisplayName("입력 받은 문자열을 int형으로 잘 변환해주는지 확인")
    void convertStringToInt() {
        String inputString = "1";

        assertThat(Converter.stringToInt(inputString)).isEqualTo(1);
    }

}
