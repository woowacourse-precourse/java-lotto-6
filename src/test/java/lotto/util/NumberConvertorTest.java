package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberConvertorTest {

    @Test
    @DisplayName("쉼표로 구분된 숫자 입력을 숫자들로 변환할 수 있다.")
    void convertToNumbersTest() {
        assertThat(NumberConvertor.convertToNumbers("1, 2,3,4,"))
            .isInstanceOf(List.class);
    }

    @Test
    @DisplayName("숫자 입력을 숫자로 변환할 수 있다.")
    void convertToNumberTest() {
        assertThat(NumberConvertor.convertToNumber("1"))
            .isInstanceOf(Integer.class);
    }

    @Test
    @DisplayName("숫자가 아닌 입력의 경우 변환시 예외를 발생시킨다.")
    void convertToNumbersNotNumberTest() {
        assertThatThrownBy(() -> NumberConvertor.convertToNumbers("1, 2,4, not Number"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
