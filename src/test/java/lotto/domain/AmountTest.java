package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AmountTest {

    @Test
    @DisplayName("금액이 1,000보다 작으면 예외를 발생시킨다.")
    void throwExceptionAmountValueLessThan1000() {
        //given
        int value = 0;
        //when //then
        assertThatThrownBy(() -> new Amount(value))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 구입 금액은 최소 1,000원부터입니다.");
    }

    @Test
    @DisplayName("금액이 1,000의 배수가 아닐 경우 예외를 발생시킨다.")
    void throwExceptionAmountValueNotMultiple1000() {
        int value = 1001;
        //when //then
        assertThatThrownBy(() -> new Amount(value))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 구입 금액은 1,000의 단위로 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("금액이 1,000의 배수일 경우 예외를 발생시키지 않는다.")
    void notThrowExceptionAmountValueMultiple1000() {
        int value = 1000;
        //when //then
        assertThatCode(() -> new Amount(value))
            .doesNotThrowAnyException();
    }
}