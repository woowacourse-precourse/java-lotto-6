package lotto.domain.lottery;

import lotto.exception.ErrorMessage;
import lotto.fixture.BuyerFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static lotto.exception.ErrorMessage.NOT_ENOUGH_PAYMENT;
import static lotto.exception.ErrorMessage.PAYMENT_NOT_DIVISIBLE_BY_UNIT_PRICE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("[Domain Layer] Buyer")
class BuyerTest {


    @Nested
    @DisplayName("[from] 정적 팩토리 메소드 / 생성자 테스트")
    class from {

        /**
         * Buyer 객체 생성자 예외처리
         * 1. 로또 판매 단위금액(Default : 1000) 미만의 요청
         * 2. 1회당 로또 최대 판매금액(Default : 10,000,000)을 초과하는 요청
         * 3. 단위가격으로 나누어 떨어지지 않는 요청
         */

        @Test
        @DisplayName("[Success] 정상적인 구매 금액 인자로 객체 생성 성공")
        void Should_Success_When_Valid() {
            // given
            final BuyerFixture valid = BuyerFixture.VALID;
            // when && then
            Assertions.assertDoesNotThrow(valid::toEntity);
        }

        @Test
        @DisplayName("[Exception] 1회당 로또 최대 판매금액(Default : 10,000,000)을 초과하는 요청 예외처리")
        void Should_ThrowException_When_SmallerPaymentThanUnitPrice() {
            // given
            final BuyerFixture negative = BuyerFixture.NEGATIVE_INTEGER;
            final BuyerFixture zero = BuyerFixture.ZERO;
            final BuyerFixture tooSmall = BuyerFixture.SMALLER_THAN_UNIT_PRICE;
            // when && then
            assertAll(
                    () -> assertThatThrownBy(negative::toEntity)
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(NOT_ENOUGH_PAYMENT.getMessage()),
                    () -> assertThatThrownBy(zero::toEntity)
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(NOT_ENOUGH_PAYMENT.getMessage()),
                    () -> assertThatThrownBy(tooSmall::toEntity)
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(NOT_ENOUGH_PAYMENT.getMessage())
            );
        }

        @Test
        @DisplayName("[Exception] 1회 최대 구입 가격(Default = 10,000,000) 초과로 예외처리")
        void Should_ThrowException_When_OutOfRangePayment() {
            // given
            final BuyerFixture tooBig = BuyerFixture.TOO_BIG;
            // when && then
            assertThatThrownBy(tooBig::toEntity)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.NUMBER_OUT_OF_RANGE.getMessage());
        }

        @Test
        @DisplayName("[Exception] 단위가격으로 나누어 떨어지지 않는 요청 예외처리")
        void Should_ThrowException_When_CantDivisiblePaymentByUnitPrice() {
            // given
            final BuyerFixture cantDivisibleByUnitPrice = BuyerFixture.CANT_DIVISIBLE_BY_UNIT_PRICE;
            // when && then
            assertThatThrownBy(cantDivisibleByUnitPrice::toEntity)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(PAYMENT_NOT_DIVISIBLE_BY_UNIT_PRICE.getMessage());
        }
    }
}
