package lotto.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(ReplaceUnderscores.class)
class RankTest {

    @ParameterizedTest(name = "일치하는 번호가 {0}개 & 보너스 번호와 일치여부가 {1}이면 {2}등이다")
    @CsvSource(
            value = {
                    "6/false/FIRST",
                    "5/true/SECOND",
                    "5/false/THIRD",
                    "4/false/FOURTH",
                    "3/false/FIFTH",
                    "2/false/MISS"
            },
            delimiter = '/'
    )
    void 일치하는_번호_개수와_보너스_번호_일치_여부로_등수_변환에_성공한다(int matchCount, boolean matchBonus, Rank rank) {
        // when
        Rank result = Rank.valueOf(matchCount, matchBonus);

        // then
        assertThat(result).isEqualTo(rank);
    }

}
