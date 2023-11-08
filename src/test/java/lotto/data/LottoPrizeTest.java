package lotto.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoPrizeTest {
    @ParameterizedTest
    @DisplayName("해당되는 로또 등수를 반환한다.")
    @CsvSource(value = {"3,true,FIFTH", "5,true,SECOND", "0,true,NONE", "6,false,FIRST"}, delimiter = ',')
    void getLottoPrize(int matchCount, boolean isBonusNumberMatched, LottoPrize expectedLottoPrize) {
        LottoPrize lottoPrize = LottoPrize.of(matchCount, isBonusNumberMatched);
        assertEquals(lottoPrize, expectedLottoPrize);
    }
}
