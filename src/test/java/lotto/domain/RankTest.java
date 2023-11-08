package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankTest {

    @ParameterizedTest
    @CsvSource({"6,false,FIRST", "5,true,SECOND", "5,false,THIRD", "4,false,FOURTH","3,false,FIFTH","0,true,NORANK"})
    void findRankTest(int matchNumberCnt, boolean isBonus, String expected){
        //When
        Rank rank = Rank.findRank(matchNumberCnt, isBonus);
        //Then
        assertThat(rank.name()).isEqualTo(expected);

    }

}