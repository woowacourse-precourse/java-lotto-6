package lotto.domain.prize;

import lotto.domain.prize.constants.PrizeGrade;
import lotto.service.FinalResultService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;

import static lotto.fixture.PrizeGradeListFixture.VALID;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("[Domain Layer] FinalResultsTest")
class FinalResultsTest {

    @Nested
    @DisplayName("[from] 정적 팩토리 메소드 / 생성자 테스트")
    class from {

        @Test
        @DisplayName("[Success] 정상적인 PrizeGradeList로 FinalResults 객체를 생성")
        void Should_Success_When_Valid() {
            // given
            List<PrizeGrade> prizeGrades = VALID.getPrizeGrades();
            EnumMap<PrizeGrade, Integer> prizeGradeCountsMap = FinalResultService.generateResult(prizeGrades);
            // when && then
            assertDoesNotThrow(() -> FinalResults.from(prizeGradeCountsMap));
        }
    }

    @Nested
    @DisplayName("[calculateFinalRevenueAmount] 최종 수익 금액을 계산")
    class calculateFinalRevenueAmount {

        @Test
        @DisplayName("[Success] 당첨된 로또의 총 수익 금액 계산에 성공")
        void Should_Success_When_Valid() {
            // given
            List<PrizeGrade> prizeGrades = VALID.getPrizeGrades();
            EnumMap<PrizeGrade, Integer> prizeGradeCountMap = FinalResultService.generateResult(prizeGrades);
            FinalResults finalResults = FinalResults.from(prizeGradeCountMap);
            // when
            long result = finalResults.calculateFinalRevenueAmount();
            long expected = prizeGrades.stream()
                    .mapToLong(PrizeGrade::getPrizeAmount)
                    .sum();
            // then
            assertEquals(result, expected);
        }
    }
}
