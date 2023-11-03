package lotto;

import lotto.view.ViewValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @DisplayName("당첨 번호 숫자가 6개인지 확인한다.")
    @Test
    void validateWinningNumberSize() {
        // given
        ViewValidator viewValidator = new ViewValidator();
        List<String> winningNumbersText = List.of("1", "2", "3", "4", "5", "6");

        // expected
        viewValidator.validateWinningNumberSize(winningNumbersText);
    }

    @DisplayName("당첨 번호 숫자가 6개가 아니면 예외가 발생한다.")
    @Test
    void validateWinningNumberSizeFail() {
        // given
        ViewValidator viewValidator = new ViewValidator();
        List<String> winningNumbersText = List.of("1", "2", "3", "4", "5");

        // expected
        assertThatThrownBy(() -> viewValidator.validateWinningNumberSize(winningNumbersText))
                .isInstanceOf(IllegalArgumentException.class);
    }
}