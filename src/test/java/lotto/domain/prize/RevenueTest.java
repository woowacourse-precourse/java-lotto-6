package lotto.domain.prize;

import lotto.domain.lottery.Buyer;
import lotto.domain.prize.constants.PrizeGrade;
import lotto.fixture.BuyerFixture;
import lotto.service.FinalResultService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;

import static lotto.fixture.PrizeGradeListFixture.VALID;

@DisplayName("[Domain Layer] Revenue Test")
class RevenueTest {

    @Nested
    @DisplayName("[from] 정적 팩토리 메소드 / 생성자 테스트")
    class from {

        @Test
        @DisplayName("[Success] 정상적인 객체로 생성에 성공")
        void tdd() {
            // given
            Buyer buyer = BuyerFixture.VALID.toEntity();
            List<PrizeGrade> prizeGrades = VALID.getPrizeGrades();
            EnumMap<PrizeGrade, Integer> prizeGradeCountMap = FinalResultService.generate(prizeGrades);
            FinalResults finalResults = FinalResults.from(prizeGradeCountMap);
            // when &&  then
            Assertions.assertDoesNotThrow(() -> Revenue.of(buyer, finalResults));
        }
    }
}
