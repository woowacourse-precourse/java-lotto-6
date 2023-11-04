package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("숫자 객체에 대해")
class NumberTest {

    @Test
    @DisplayName("숫자 값을 저장하면 String으로 값을 받을 수 있다.")
    void When_saveValue_Then_getString() {
        //given
        Number number = new Number(3);

        //when
        String numberValue = number.getValue();

        //then
        assertThat(numberValue).isEqualTo("3")
                .isInstanceOf(String.class);
    }
}
