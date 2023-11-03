package lotto;

import lotto.view.ViewValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ViewValidatorTest {

    @DisplayName("문자열을 정수형으로 변환한다.")
    @Test
    void parseInt() {
        // given
        ViewValidator viewValidator = new ViewValidator();
        String text = "123";

        // when
        int parseInt = viewValidator.parseInt(text);

        // then
        assertThat(parseInt).isEqualTo(123);
    }

    @DisplayName("문자열을 정수형으로 변환할 수 없으면 예외가 발생한다.")
    @Test
    void parseIntFail() {
        // given
        ViewValidator viewValidator = new ViewValidator();
        String text = "TestText";

        // expected
        assertThatThrownBy(() -> viewValidator.parseInt(text))
                .isInstanceOf(IllegalArgumentException.class);
    }
}