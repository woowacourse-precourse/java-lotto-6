package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankingTest {

    @ParameterizedTest
    @CsvSource({"3,false,FIFTH", "5,false,THIRD", "5,true,SECOND", "0,true,NONE"})
    void findFrom(int matchCount, boolean isBonusMatched, String nameExpected) {

        assertThat(Ranking.findFrom(matchCount, isBonusMatched).name()).isEqualTo(nameExpected);

    }
}
