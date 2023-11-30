package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ExceptionHandlerTest {
    @DisplayName("1,000원 단위의 양의 정수 값을 입력하면 ExceptionStatus의 NOT_OCCURED 상태를 반환한다.")
    @ParameterizedTest
    @CsvSource({"1000", "3000", "10000", "600000", "7000000"})
    void handleMoneyFormatExceptionFromMultipleOfLottoPricePositiveInteger(String purchaseAmount) {
        // given, when
        ExceptionStatus exceptionStatus = ExceptionHandler.handleMoneyInputException(purchaseAmount);

        // then
        assertThat(exceptionStatus.isOccurred()).isFalse();
    }

    @DisplayName("양의 정수가 아닌 값을 입력하면 ExceptionStatus의 OCCURED 상태를 반환한다.")
    @ParameterizedTest
    @CsvSource({"0", "-1", "가나다라마바사", "abcdef", "12ab가나", "ab12가나"})
    void handleMoneyFormatExceptionFromNotPositiveInteger(String purchaseAmount) {
        // given, when
        ExceptionStatus exceptionStatus = ExceptionHandler.handleMoneyInputException(purchaseAmount);

        // then
        assertThat(exceptionStatus.isOccurred()).isTrue();
    }

    @DisplayName("1,000원 단위가 아닌 양의 정수 값을 입력하면 ExceptionStatus의 OCCURED 상태를 반환한다.")
    @ParameterizedTest
    @CsvSource({"1", "50", "999", "1001", "4999", "50001"})
    void handleMoneyFormatExceptionFromNotMultipleOfLottoPricePositiveInteger(String purchaseAmount) {
        // given, when
        ExceptionStatus exceptionStatus = ExceptionHandler.handleMoneyInputException(purchaseAmount);

        // then
        assertThat(exceptionStatus.isOccurred()).isTrue();
    }
}