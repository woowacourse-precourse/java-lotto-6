package lotto;

import org.junit.jupiter.api.Test;
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

    @Test
    void 메시지_반환() {

        //given
        Rank rank = Rank.FIRST;

        //when
        String result = rank.getMessage();

        //then
        assertThat(result).isEqualTo("6개 일치 (2,000,000,000원) - ");
    }
}
