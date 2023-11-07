package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest{

    @ParameterizedTest
    @CsvSource(value = {"3, false, FIFTH", "5, true, SECOND", "6, false, FIRST", "2, false, NO_RANK"})
    void 등수_판별(int matchCount, boolean bonus, String expected) {

        //given
        Rank result = Rank.getRank(matchCount, bonus);

        //then
        assertThat(result).isEqualTo(Rank.valueOf(expected));
    }
}
