package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("타입 변환기 테스트")
class TypeConverterTest {

    @DisplayName("정수가 입력된 경우 문자열을 정수로 바꿀 수 있다")
    @Test
    void testNumericInputConvert() {
        Integer converted = TypeConverter.StringToInteger("1");
        assertThat(converted).isEqualTo(1);
    }

    @DisplayName("정수가 아닌 다른 입력이 주어진 경우 예외를 발생시킨다")
    @Test
    void testNonNumbericInputConvert() {
        assertThatThrownBy(() -> TypeConverter.StringToInteger("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_TYPE.getErrorMessage());
    }
}