package lotto.domain.prize;

import lotto.domain.lottery.Lottos;
import lotto.domain.prize.constants.PrizeGrade;
import lotto.fixture.NumberFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("[Domain Layer] MatchingResults")
public class MatchingResultsTest {

    @Nested
    @DisplayName("[of] 정적 팩토리 메소드 / 생성자 테스트")
    class from {

        @Test
        @DisplayName("[Success] 정상적인 매칭 결과 리스트 인자로 객체 생성 성공")
        void Should_Success_When_Valid() {
            // given
            final int lottoCount = 1;
            Prize prize = NumberFixture.VALID.toPrizeEntity();
            Lottos lottos = Lottos.from(lottoCount);
            List<MatchingResult> matchingResultList = lottos.generateMatchingResultList(prize);
            // when && then
            Assertions.assertDoesNotThrow(() -> MatchingResults.from(matchingResultList));
        }
    }

    @Nested
    @DisplayName("[findPrizeGrade] List<MatchingResult> 객체를 순회하며 해당 결과의 순위를 조사해 List<PrizeGrade>를 리턴")
    class findPrizeGrade {

        @Test
        @DisplayName("[Success] 로또 매칭 결과를 바탕으로, 해당 로또들의 순위 리스트를 리턴")
        void Should_Success_When_Valid() {
            // given
            final int lottoCount = 3;
            Prize prize = NumberFixture.VALID.toPrizeEntity();
            Lottos lottos = Lottos.from(lottoCount);
            List<MatchingResult> matchingResultList = lottos.generateMatchingResultList(prize);
            // when && then
            MatchingResults results = MatchingResults.from(matchingResultList);
            List<PrizeGrade> prizeGrades = results.findPrizeGrade();
            assertThat(prizeGrades).hasSize(lottoCount);
        }
    }
}
