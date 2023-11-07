package lotto.constant;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankTest {
    @ParameterizedTest
    @CsvSource(value = {"5,true,SECOND", "5,false,THIRD"})
    void 맞는_번호수와_보너스_여부에_따라서_등수_계산(int count, boolean isBonus, String word) {
        Rank rank = Rank.getRank(count, isBonus);
        Rank expected = Rank.valueOf(word);

        assertThat(rank).isEqualTo(expected);
    }
}