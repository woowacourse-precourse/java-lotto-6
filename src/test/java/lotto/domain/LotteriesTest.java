package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LotteriesTest {
    
    @Nested
    @DisplayName("[Lotteries] 입력 테스트")
    class LotteriesSuccessTest {
        
        @DisplayName("로또 발행이 정상적으로 진행되는 경우를 확인")
        @ParameterizedTest
        @ValueSource(strings = {"1000", "3000", "6000"})
        void create_로또_발행이_정상적으로_진행되는_경우를_확인(String amount) {
            Payment payment = Payment.from(amount);
            
            assertThatNoException().isThrownBy(()
                    -> Lotteries.from(payment));
        }
    }
    
    @Nested
    @DisplayName("[Lotteries] 기능 테스트")
    class LotteriesUnitTest {
        
        @Test
        @DisplayName("발행한 로또 리스트를 정상적으로 반환하는지 확인")
        void toString_발행한_로또_리스트를_정상적으로_반환하는지_확인() {
            Payment payment = Payment.from("8000");
            
            Lotteries lotteries = Lotteries.from(payment);
            List<String> result = lotteries.receiveLotteriesInfo();
            
            assertThat(result.size()).isEqualTo(8);
        }
    }
}