package lotto.domain;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("LottoRank 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoRankTest {

    @ParameterizedTest
    @MethodSource("provideMatchCountAndMatchBonus")
    void of_정적_팩토리_메소드는_당첨개수와_보너스당첨_여부가_주어지면_해당_LottoRank를_반환한다(int matchCount, boolean matchBonus, LottoRank expect) {
        Assertions.assertEquals(LottoRank.of(matchCount, matchBonus), expect);
    }

    private static Stream<Arguments> provideMatchCountAndMatchBonus() {
        return Stream.of(
                Arguments.of(3, true, LottoRank.FIFTH),
                Arguments.of(4, true, LottoRank.FOURTH),
                Arguments.of(5, false, LottoRank.THIRD),
                Arguments.of(5, true, LottoRank.SECOND),
                Arguments.of(6, false, LottoRank.FIRST)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"3:15000", "5:25000", "100:500000"}, delimiter = ':')
    void calculatePrizeAmount_메소드는_해당_등수의_수량이_주어지면_상금을_반환한다(int count, int expect) {
        Assertions.assertEquals(LottoRank.FIFTH.calculatePrizeAmount(count), expect);
    }

    @Test
    void isContainBonusRank_메소드는_보너스볼이_포함된_등수이면_true를_반환한다() {
        Assertions.assertTrue(LottoRank.SECOND.isContainBonusRank());
    }

    @ParameterizedTest
    @EnumSource(value = LottoRank.class, names = {"NOTHING", "FIFTH", "FOURTH", "THIRD","FIRST"})
    void isContainBonusRank_메소드는_보너스볼이_포함되지_않은_등수이면_false를_반환한다(LottoRank lottoRank) {
        Assertions.assertFalse(lottoRank.isContainBonusRank());
    }


}
