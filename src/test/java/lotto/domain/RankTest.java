package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankTest {

    @ParameterizedTest
    @CsvSource(value = {"6,true", "6,false"})
    void firstRank(int matchCount, boolean bonusMatch) {
        Rank rank = Rank.calculateRank(matchCount, bonusMatch);
        Assertions.assertThat(rank).isSameAs(Rank.FIRST);
    }

    @ParameterizedTest
    @CsvSource(value = {"5,true"})
    void secondRank(int matchCount, boolean bonusMatch) {
        Rank rank = Rank.calculateRank(matchCount, bonusMatch);
        Assertions.assertThat(rank).isSameAs(Rank.SECOND);
    }

    @ParameterizedTest
    @CsvSource(value = {"5,false"})
    void thirdRank(int matchCount, boolean bonusMatch) {
        Rank rank = Rank.calculateRank(matchCount, bonusMatch);
        Assertions.assertThat(rank).isSameAs(Rank.THIRD);
    }

    @ParameterizedTest
    @CsvSource(value = {"4,true", "4,false"})
    void fourthRank(int matchCount, boolean bonusMatch) {
        Rank rank = Rank.calculateRank(matchCount, bonusMatch);
        Assertions.assertThat(rank).isSameAs(Rank.FOURTH);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,true", "3,false"})
    void fifthRank(int matchCount, boolean bonusMatch) {
        Rank rank = Rank.calculateRank(matchCount, bonusMatch);
        Assertions.assertThat(rank).isSameAs(Rank.FIFTH);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2,true", "2,false",
            "1,true", "1,false",
            "0,true", "0,false",
            "-1,true", "-1,false"})
    void noneRank(int matchCount, boolean bonusMatch) {
        Rank rank = Rank.calculateRank(matchCount, bonusMatch);
        Assertions.assertThat(rank).isSameAs(Rank.NONE);
    }

}