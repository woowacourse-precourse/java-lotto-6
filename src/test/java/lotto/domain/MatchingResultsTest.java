package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MatchingResultsTest {
    
    @Nested
    @DisplayName("[MatchingResults] 기능 테스트")
    class MatchingResultsUnitTest {
        
        @Test
        @DisplayName("로또 게임 결과 리스트를 통해 당첨 순위 리스트를 반환한다")
        void stream_로또_게임_결과_리스트를_통해_당첨_순위_리스트를_반환한다() {
            Payment payment = Payment.from("8000");
            Lotteries lotteries = Lotteries.from(payment);
            
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            Integer bonusNumber = 7;
            
            WinningLotto winningLotto = WinningLotto.of(lotto, bonusNumber);
            
            MatchingResults matchingResults = lotteries.generateMatchingResults(winningLotto);
            
            assertThatNoException().isThrownBy(matchingResults::receiveWinningGrades);
        }
    }
}