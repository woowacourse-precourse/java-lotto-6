package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LotteriesTest {
    
    @Nested
    @DisplayName("[Lotteries] 정상 테스트")
    class LotteriesSuccessTest {
        
        @DisplayName("로또 발행이 정상적으로 진행되는 경우를 확인한다")
        @ParameterizedTest
        @ValueSource(strings = {"1000", "3000", "6000"})
        void create_로또_발행이_정상적으로_진행되는_경우를_확인한다(String amount) {
            Payment payment = Payment.from(amount);
            
            assertThatNoException().isThrownBy(()
                    -> Lotteries.from(payment));
        }
    }
    
    @Nested
    @DisplayName("[Lotteries] 기능 테스트")
    class LotteriesUnitTest {
        
        @DisplayName("발행한 로또 리스트를 정상적으로 반환한다")
        @ParameterizedTest
        @CsvSource({"8000, 8", "1000, 1", "10000, 10"})
        void toString_발행한_로또_리스트를_정상적으로_반환한다(String amount, int size) {
            Payment payment = Payment.from(amount);
            
            Lotteries lotteries = Lotteries.from(payment);
            List<String> result = lotteries.receiveLotteriesInfo();
            
            assertThat(result.size())
                    .isEqualTo(size);
        }
        
        @Test
        @DisplayName("로또 게임 결과를 만들어서 반환한다")
        void create_로또_게임_결과를_만들어서_반환한다() {
            Payment payment = Payment.from("8000");
            Lotteries lotteries = Lotteries.from(payment);
            
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            Integer bonusNumber = 7;
            
            WinningLotto winningLotto = WinningLotto.of(lotto, bonusNumber);
            
            assertThat(lotteries.generateMatchingResults(winningLotto))
                    .isInstanceOf(MatchingResults.class);
        }
    }
}