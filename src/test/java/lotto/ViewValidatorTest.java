package lotto;

import lotto.view.valid.ViewValidator;
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

    @DisplayName("당첨 번호 6개가 모두 숫자형으로 변환할 수 있는지 확인한다.")
    @Test
    void validateWinningNumberFormat() {
        // given
        ViewValidator viewValidator = new ViewValidator();
        List<String> winningNumbersText = List.of("1", "2", "3", "4", "5", "6");

        // when
        List<Integer> winningNumbers = viewValidator.validateWinningNumberFormat(winningNumbersText);

        // then
        assertThat(winningNumbers.size()).isEqualTo(6);
    }

    @DisplayName("당첨 번호 6개 중에 숫자로 변환할 수 없는 문자열이 존재하면 예외가 발생한다.")
    @Test
    void validateWinningNumberFormatFail() {
        // given
        ViewValidator viewValidator = new ViewValidator();
        List<String> winningNumbersText = List.of("1", "2", "3", "4", "5", "fail");

        // expected
        assertThatThrownBy(() -> viewValidator.validateWinningNumberFormat(winningNumbersText))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 최소 금액이 넘는지 확인한다.")
    @Test
    void validateMinPrice() {
        // given
        ViewValidator viewValidator = new ViewValidator();
        int buyingPrice = 1;

        // expected
        viewValidator.validateMinPrice(buyingPrice);
    }

    @DisplayName("구입 금액이 최소 구입 금액을 넘지 않으면 예외가 발생한다.")
    @Test
    void validateMinPriceFail() {
        // given
        ViewValidator viewValidator = new ViewValidator();
        int buyingPrice = -1;

        // expected
        assertThatThrownBy(() ->  viewValidator.validateMinPrice(buyingPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 구입 최소 단위로 나누어 떨어지는지 확인한다.")
    @Test
    void validateMod() {
        // given
        ViewValidator viewValidator = new ViewValidator();
        int buyingPrice = 10000;

        // expected
        viewValidator.validateMod(buyingPrice);
    }

    @DisplayName("구입 금액이 구입 최소 단위로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void validateModFail() {
        // given
        ViewValidator viewValidator = new ViewValidator();
        int buyingPrice = 1001;

        // expected
        assertThatThrownBy(() ->  viewValidator.validateMod(buyingPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }
}