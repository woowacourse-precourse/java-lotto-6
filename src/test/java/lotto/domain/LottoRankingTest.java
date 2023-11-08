package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoRankingTest {
    @ParameterizedTest
    @CsvSource(value = {"3,true", "4,false", "5,true", "6,false", "1,false"})
    @DisplayName("로또 등수를 반환한다.")
    void lottoRankTest(int matchingNumber, boolean isBonusInclude) {
        String prizeName = LottoRanking.valueOf(matchingNumber, isBonusInclude).name();
        Map<Integer, String> prizeMap = new HashMap<>() {{
            put(3, "FIFTH");
            put(4, "FOURTH");
            put(5, "SECOND");
            put(6, "FIRST");
            put(1, "NO_MATCH");
        }};

        for (int i = 0; i < prizeMap.size(); i++) {
            String expect = prizeMap.get(matchingNumber);
            assertEquals(expect, prizeName);
        }
    }
}
