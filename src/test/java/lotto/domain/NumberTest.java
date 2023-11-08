package lotto.domain;

import lotto.constants.message.ErrorMessage;
import lotto.domain.lotto.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("숫자 객체에 대해")
class NumberTest {

    private static final String error = ErrorMessage.ERROR_TAG.toString();

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("숫자 값을 저장할 수 있다")
    void Given_CreateNumber_When_saveValue_Then_getString(Integer value) {
        //given
        Number number = new Number(value);

        //when
        Integer actual = number.getValue();

        //then
        assertThat(actual).isEqualTo(value)
                .isInstanceOf(Integer.class);
    }

    @Test
    @DisplayName("null 값이 저장되었을 경우 에러가 발생한다.")
    void When_CreateNumberValueNull_Then_ThrowException() {
        //when
        Number number = new Number(null);

        //then
        assertThatThrownBy(number::getValue)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(error);
    }
}
