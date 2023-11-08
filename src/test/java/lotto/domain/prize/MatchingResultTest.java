package lotto.domain.prize;

import lotto.domain.lottery.Lotto;
import lotto.domain.prize.constants.PrizeMatchingCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static lotto.domain.prize.constants.PrizeMatchingCount.FIVE;
import static lotto.domain.prize.constants.PrizeMatchingCount.SIX;
import static lotto.fixture.NumberFixture.VALID;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("[Domain Layer] MatchingResult")
class MatchingResultTest {

    @Nested
    @DisplayName("[of] 정적 팩토리 메소드 / 생성자 테스트")
    class of {
        @Test
        @DisplayName("[Success] 정상적인 Lotto / Prize 인자로 객체 생성 성공")
        void Should_Success_When_Valid() {
            // given
            Lotto lotto = VALID.toLottoEntity();
            Prize prize = VALID.toPrizeEntity();
            // when
            MatchingResult result = MatchingResult.of(lotto, prize);
            // then
            PrizeMatchingCount prizeMatchingCount = result.getPrizeMatchingCount();
            boolean matchingBonus = result.getBonusMatching();

            assertAll(
                    () -> assertEquals(prizeMatchingCount, SIX),
                    () -> assertFalse(matchingBonus)
            );
        }
    }

    @Nested
    @DisplayName("[isSamePrizeMatchingCount] 동일한 enum 값이면 true, 아니라면 false 리턴")
    class isSamePrizeMatchingCount {

        @Test
        @DisplayName("[Success] 동일한 enum값이므로 true 리턴")
        void Should_ReturnTrue_When_Same() {
            // given
            Lotto lotto = VALID.toLottoEntity();
            Prize prize = VALID.toPrizeEntity();
            MatchingResult result = MatchingResult.of(lotto, prize);
            PrizeMatchingCount expected = SIX;
            // when && then
            assertTrue(result.isSamePrizeMatchingCount(expected));
        }

        @Test
        @DisplayName("[Success] 동일한 enum값이 아니므로 false 리턴")
        void Should_ReturnFalse_When_Different() {
            // given
            Lotto lotto = VALID.toLottoEntity();
            Prize prize = VALID.toPrizeEntity();
            MatchingResult result = MatchingResult.of(lotto, prize);
            PrizeMatchingCount notContainPrizeMatchingCount = FIVE;
            // when && then
            assertFalse(result.isSamePrizeMatchingCount(notContainPrizeMatchingCount));
        }
    }
}
