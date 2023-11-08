package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoRankingTest {
    @ParameterizedTest
    @CsvSource(value = {
            "3,true,FIFTH",
            "4,false,FOURTH",
            "5,true,SECOND",
            "5,false,THIRD",
            "6,false,FIRST",
            "1,false,NO_MATCH"
    })
    @DisplayName("로또 등수를 반환한다.")
    void lottoRankTest(int matchingNumber, boolean isBonusInclude, String expectedRank) {
        String actualRank = LottoRanking.valueOf(matchingNumber, isBonusInclude).name();
        assertEquals(expectedRank, actualRank);
    }
}
