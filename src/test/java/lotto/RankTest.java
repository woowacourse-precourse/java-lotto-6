package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankTest {
    @DisplayName("등수에 따른 결과 문자열 생성")
    @ParameterizedTest
    @CsvSource({
            "FIRST, 10, '6개 일치 (2,000,000,000원) - 10개'",
            "SECOND, 3, '5개 일치, 보너스 볼 일치 (30,000,000원) - 3개'",
            "THIRD, 4, '5개 일치 (1,500,000원) - 4개'",
            "FOURTH, 1, '4개 일치 (50,000원) - 1개'",
            "FIFTH, 100,'3개 일치 (5,000원) - 100개'"
    })
    void testgetMessage(Rank rank, int count, String expected) {
        String result = rank.getMessage(count);

        assertEquals(expected, result);
    }
}