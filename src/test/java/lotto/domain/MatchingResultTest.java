package lotto.domain;

import static lotto.enums.MatchingCount.THREE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import java.util.function.UnaryOperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MatchingResultTest {
    
    static MatchingResult createMatchingResultWithBonusNumber(int bonusNumber) {
        List<Integer> lottoNumbers = List.of(1, 2, 7, 8, 9, 10);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    
        Lotto lotto = new Lotto(lottoNumbers);
        WinningLotto winningLotto = WinningLotto.of(new Lotto(winningNumbers), bonusNumber);
    
        return MatchingResult.of(lotto, winningLotto);
    }
    
    @Nested
    @DisplayName("[MatchingResult] 정상 테스트")
    class MatchingResultSuccessTest {
        
        @Test
        @DisplayName("로또 정보와 당첨 로또 정보를 받아서 객체를 생성한다")
        void create_로또_정보와_당첨_로또_정보를_받아서_객체를_생성한다() {
            assertThatNoException().isThrownBy(
                    () -> createMatchingResultWithBonusNumber(10));
        }
    }
    
    @Nested
    @DisplayName("[MatchingResult] 기능 테스트")
    class MatchingResultUnitTest {
        
        @DisplayName("보너스 번호 매칭 여부를 boolean으로 반환한다")
        @ParameterizedTest
        @CsvSource({"7, true", "11, false", "10, true", "45, false"})
        void apply_보너스_번호_매칭_여부를_boolean으로_반환한다(
                int bonusNumber, boolean matchBoolean) {
            
            MatchingResult sampleMatchingResult = createMatchingResultWithBonusNumber(bonusNumber);
            UnaryOperator<Boolean> matchingBonus = (correctBonusNumber) -> correctBonusNumber;
            
            assertThat(sampleMatchingResult.isBonusMatching(matchingBonus))
                    .isEqualTo(matchBoolean);
        }
        
        @Test
        @DisplayName("로또 번호 매칭 결과를 확인한다")
        void equals_로또_번호_매칭_결과를_확인한다() {
            MatchingResult sampleMatchingResult = createMatchingResultWithBonusNumber(10);
            
            assertThat(sampleMatchingResult.isSameMatchingCount(THREE))
                    .isTrue();
        }
    }
}