package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankingTest {

    @ParameterizedTest
    @CsvSource(value = {"0,NO_PRIZE", "1,NO_PRIZE", "2,NO_PRIZE", "3,FIFTH_PLACE", "4,FOURTH_PLACE",
            "5,THIRD_PLACE", "6,FIRST_PLACE"})
    void matchingNumber에_따라_Ranking_enum을_반환한다(int matchingNumber, Ranking expected) {
        Ranking actual = Ranking.getRanking(matchingNumber);
        assertThat(actual).isEqualTo(expected);
    }
}
