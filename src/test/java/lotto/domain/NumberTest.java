package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("숫자 객체에 대해")
class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("숫자 값을 저장할 수 있다")
    void Given_CreateNumber_When_saveValue_Then_getString(Integer value) {
        //given
        Number number = new Number(value);

        //when
        Integer numberValue = number.getValue();

        //then
        assertThat(numberValue).isEqualTo(value)
                .isInstanceOf(Integer.class);
    }
}
