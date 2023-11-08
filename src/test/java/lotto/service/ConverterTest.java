package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConverterTest {

    @DisplayName("입력받은 구매금액이 공백이면 예외가 발생한다.")
    @Test
    void getPaymentPriceByNone() {
        assertThatThrownBy(() -> Converter.paymentPrice(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.REQUIRE_NONEMPTY_INPUT.getMessage());
    }

    @DisplayName("입력받은 구매금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void getPaymentPriceByNonInteger() {
        assertThatThrownBy(() -> Converter.paymentPrice("-"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.REQUIRE_POSITIVE_LONG.getMessage());
    }

    @DisplayName("입력받은 구매금액이 long의 최대값 이상이면 예외가 발생한다.")
    @Test
    void getPaymentPriceByOverLong() {
        assertThatThrownBy(() -> Converter.paymentPrice("9223372036854776000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.REQUIRE_POSITIVE_LONG.getMessage());
    }

    @DisplayName("입력받은 당첨 번호가 공백이면 예외가 발생한다.")
    @Test
    void getWinningNumbersByNone() {
        assertThatThrownBy(() -> Converter.winningNumbers(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.REQUIRE_NONEMPTY_INPUT.getMessage());
    }

    @DisplayName("입력받은 당첨 번호가 ,(컴마)로 시작하면 예외가 발생한다.")
    @Test
    void getWinningNumbersByStartsWithComma() {
        assertThatThrownBy(() -> Converter.winningNumbers(",1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.REQUIRE_NOT_STARTS_WITH_COMMA.getMessage());
    }

    @DisplayName("입력받은 당첨 번호가 ,(컴마)로 끝나면 예외가 발생한다.")
    @Test
    void getWinningNumbersByEndsWithComma() {
        assertThatThrownBy(() -> Converter.winningNumbers("1,2,3,4,5,6,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.REQUIRE_NOT_ENDS_WITH_COMMA.getMessage());
    }

    @DisplayName("입력받은 당첨 번호에 ,(컴마)가 연속으로 존재하면 예외가 발생한다.")
    @Test
    void getWinningNumbersByContinuousCommas() {
        assertThatThrownBy(() -> Converter.winningNumbers("1,2,3,4,,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.REQUIRE_RIGHT_RANGE_NUMBER.getMessage());
    }

    @DisplayName("입력받은 당첨 번호에 숫자가 아닌 것이 존재하면 예외가 발생한다.")
    @Test
    void getWinningNumbersByNonInteger() {
        assertThatThrownBy(() -> Converter.winningNumbers("1,2,3,4,-,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.REQUIRE_RIGHT_RANGE_NUMBER.getMessage());
    }

    @DisplayName("입력받은 보너스 번호가 공백이면 예외가 발생한다.")
    @Test
    void getBonusNumberByNone() {
        assertThatThrownBy(() -> Converter.bonusNumbers(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.REQUIRE_NONEMPTY_INPUT.getMessage());
    }

    @DisplayName("입력받은 보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void getBonusNumberByNonInteger() {
        assertThatThrownBy(() -> Converter.bonusNumbers("-"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.REQUIRE_POSITIVE_INTEGER.getMessage());
    }
}
