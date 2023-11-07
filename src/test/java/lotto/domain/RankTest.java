package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankTest {

    @ParameterizedTest
    @CsvSource(value = "6:false", delimiterString = ":")
    public void 같은_숫자가_6개_이면_1등이다(int matchCount, boolean isBonus) {
        // given, when
        Rank actual = Rank.of(matchCount, isBonus);

        // then
        Assertions.assertThat(actual).isEqualTo(Rank.FIRST);
    }

    @ParameterizedTest
    @CsvSource(value = "5:true", delimiterString = ":")
    public void 같은_숫자가_5개_이고_보너스_번호가_당첨되었다면_2등이다(int matchCount, boolean isBonus) {
        // given, when
        Rank actual = Rank.of(matchCount, isBonus);

        // then
        Assertions.assertThat(actual).isEqualTo(Rank.SECOND);
    }

    @ParameterizedTest
    @CsvSource(value = "5:false", delimiterString = ":")
    public void 같은_숫자가_5개_이고_보너스_번호가_당첨되지_않았다면_3등이다(int matchCount, boolean isBonus) {
        // given, when
        Rank actual = Rank.of(matchCount, isBonus);

        // then
        Assertions.assertThat(actual).isEqualTo(Rank.THIRD);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:false", "4:true"}, delimiterString = ":")
    public void 같은_숫자가_4개_이면_4등이다(int matchCount, boolean isBonus) {
        // given, when
        Rank actual = Rank.of(matchCount, isBonus);

        // then
        Assertions.assertThat(actual).isEqualTo(Rank.FOURTH);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:false", "3:true"}, delimiterString = ":")
    public void 같은_숫자가_3개_이면_5등이다(int matchCount, boolean isBonus) {
        // given, when
        Rank actual = Rank.of(matchCount, isBonus);

        // then
        Assertions.assertThat(actual).isEqualTo(Rank.FIFTH);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:false", "1:false", "0:false", "2:true", "1:true", "0:true"}, delimiterString = ":")
    public void 같은_숫자가_2개_이하면_꽝이다(int matchCount, boolean isBonus) {
        // given, when
        Rank actual = Rank.of(matchCount, isBonus);

        // then
        Assertions.assertThat(actual).isEqualTo(Rank.BLANK);
    }

}