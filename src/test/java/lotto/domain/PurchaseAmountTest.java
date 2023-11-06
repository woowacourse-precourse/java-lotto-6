package lotto.domain;

import lotto.exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PurchaseAmountTest {

    @DisplayName("구입 금액 입력 값이 빈 값 또는 숫자가 아닌 경우에 대한 예외 검증")
    @ValueSource(strings = {"", "hi", "10k"})
    @ParameterizedTest
    void notNumber(String input){
        //given, when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> new PurchaseAmount(input));

        //then
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessage.NOT_NUMBER.get());
    }

    @DisplayName("구입 금액이 1보다 작을 경우에 대한 예외 검증")
    @ValueSource(strings = {"-1", "0", "-1000"})
    @ParameterizedTest
    void lessThanOneAmount(String input){
        //given, when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> new PurchaseAmount(input));

        //then
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessage.NOT_NATURAL_NUMBER.get());
    }
}