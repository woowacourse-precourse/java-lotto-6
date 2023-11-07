package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PaymentTest {
    
    @Nested
    @DisplayName("[Payment] 정상 테스트")
    class PaymentSuccessTest {
        
        @DisplayName("로또 구입 금액 입력이 정상적인 경우를 확인한다")
        @ParameterizedTest
        @ValueSource(strings = {"1000", "2000", "6000"})
        void create_로또_구입_금액_입력이_정상적인_경우를_확인한다(String amount) {
            assertThatNoException().isThrownBy(()
                    -> Payment.from(amount));
        }
    }
    
    @Nested
    @DisplayName("[Payment] 기능 테스트")
    class PriceUnitTest {
        
        @DisplayName("구입한 로또의 수를 확인한다")
        @ParameterizedTest
        @CsvSource({"1000, 1", "2000, 2", "6000, 6"})
        void count_구입한_로또의_수를_확인한다(String amount, int count) {
            Payment payment = Payment.from(amount);
            
            assertThat(payment.receiveIssuedLottoCount())
                    .isEqualTo(count);
        }
        
        @DisplayName("수익률을 계산하여 반환한다")
        @ParameterizedTest
        @CsvSource({"8000, 5000, 62.5", "8000, 2000000000, 25000000.0", "10000, 0, 0"})
        void decimal_수익률을_계산하여_반환한다(
                String amount, long totalPrice, BigDecimal profitability) {
            
            Payment payment = Payment.from(amount);
            
            assertThat(payment.calculateProfitability(totalPrice))
                    .isEqualTo(profitability);
        }
    }
    
    @Nested
    @DisplayName("[Payment] 예외 테스트")
    class PaymentExceptionTest {
        @DisplayName("로또 구입 금액 입력이 올바르지 않으면 예외가 발생한다")
        @ParameterizedTest
        @ValueSource(strings = {"0", "1", "1001", "9999"})
        void exception_로또_구입_금액_입력이_올바르지_않으면_예외가_발생한다(String amount) {
            assertThatThrownBy(() -> Payment.from(amount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
    }
}