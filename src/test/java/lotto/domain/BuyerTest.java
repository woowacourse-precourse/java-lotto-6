package lotto.domain;

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
public class BuyerTest {

    @Nested
    @DisplayName("[from] 정적 팩토리 메소드 / 생성자 테스트")
    class from {

        @Test
        @DisplayName("[Success] 정상적인 paymentInput 인자로 객체 생성 성공")
        void Should_Success_When_ValidParameter() {
            // given
            final BuyerFixture valid = BuyerFixture.VALID;
            // when && then
            Assertions.assertDoesNotThrow(valid::toEntity);
        }

        @Test
        @DisplayName("[Success] 로또 단위 가격 이하 가격 paymentInput으로 예외처리")
        void Should_ThrowException_When_SmallerPaymentThanUnitPrice() {
            // given
            final BuyerFixture negative = BuyerFixture.NEGATIVE_INTEGER;
            final BuyerFixture zero = BuyerFixture.ZERO;
            final BuyerFixture tooSmall = BuyerFixture.SMALLER_THAN_UNIT_PRICE;

            final BuyerFixture cantDivisibleByUnitPrice = BuyerFixture.CANT_DIVISIBLE_BY_UNIT_PRICE;
            final BuyerFixture tooBig = BuyerFixture.TOO_BIG;
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
        @DisplayName("[Success] 1000원 단위로 나누어지지 않는 paymentInput으로 예외처리")
        void Should_ThrowException_When_CantDivisiblePaymentByUnitPrice() {
            // given
            final BuyerFixture cantDivisibleByUnitPrice = BuyerFixture.CANT_DIVISIBLE_BY_UNIT_PRICE;

            // when && then
            assertThatThrownBy(cantDivisibleByUnitPrice::toEntity)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(PAYMENT_NOT_DIVISIBLE_BY_UNIT_PRICE.getMessage());
        }

        @Test
        @DisplayName("[Success] 1회 최대 구입 가격(Default = 10,000,000) 초과로 예외처리")
        void Should_ThrowException_When_OutOfRangePayment() {
            // given
            final BuyerFixture tooBig = BuyerFixture.TOO_BIG;

            // when && then
            assertThatThrownBy(tooBig::toEntity)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.NUMBER_OUT_OF_RANGE.getMessage());
        }
    }
}
