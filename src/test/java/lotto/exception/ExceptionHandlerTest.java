package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ExceptionHandlerTest {
    @DisplayName("양의 정수 값을 입력하면 ExceptionStatus의 NOT_OCCURED 상태를 반환한다.")
    @ParameterizedTest
    @CsvSource({"1", "9", "10", "100", "1000", "10000"})
    void handleMoneyFormatExceptionFromPositiveInteger(String purchaseAmount) {
        // given, when
        ExceptionStatus exceptionStatus = ExceptionHandler.handleMoneyFormatException(purchaseAmount);

        // then
        assertThat(exceptionStatus.isOccurred()).isFalse();
    }

    @DisplayName("양의 정수가 아닌 값을 입력하면 ExceptionStatus의 OCCURED 상태를 반환한다.")
    @ParameterizedTest
    @CsvSource({"0", "가나다라마바사", "abcdef", "12ab가나", "ab12가나", "-1"})
    void handleMoneyFormatExceptionFromNotPositiveInteger(String purchaseAmount) {
        // given, when
        ExceptionStatus exceptionStatus = ExceptionHandler.handleMoneyFormatException(purchaseAmount);

        // then
        assertThat(exceptionStatus.isOccurred()).isTrue();
    }
}