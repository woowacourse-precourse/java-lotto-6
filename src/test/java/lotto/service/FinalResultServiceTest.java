package lotto.service;

import lotto.domain.prize.constants.PrizeGrade;
import lotto.fixture.PrizeGradeListFixture;
import lotto.view.constants.PrintablePrizeGrade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("[Service Layer] FinalResultService Test")
public class FinalResultServiceTest {

    @Nested
    @DisplayName("[generateResult] List<PrizeGrade>를 바탕으로, printable한 PrizeGrade를 몇 개씩 가지고 있는지 EnumMap으로 리턴")
    class generateResult {

        @Test
        @DisplayName("[Success] List 내부 갯수에 맞게 EnumMap의 Value에 put하고, EnumMap을 리턴")
        void Should_Success_When_Valid() {
            // given
            List<PrizeGrade> prizeGrades = PrizeGradeListFixture.VALID.getPrizeGrades();
            // when
            EnumMap<PrizeGrade, Integer> result = FinalResultService.generateResult(prizeGrades);
            // then
            PrintablePrizeGrade[] entirePrizeGrade = PrintablePrizeGrade.values();
            final int eachContainCount = 1;

            Arrays.stream(entirePrizeGrade)
                    .forEach(grade -> assertEquals(result.get(grade.getGrade()), eachContainCount));
        }
    }
}
