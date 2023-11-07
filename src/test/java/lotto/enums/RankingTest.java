package lotto.enums;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static lotto.enums.Ranking.*;

class RankingTest {
    private static final List<Integer> PRIZES = List.of(0, 5_000, 50_000, 1_500_000, 30_000_000, 2_000_000_000);
    private static final List<String> RESULTS = List.of("낙첨", "3개 일치 (5,000원) - ", "4개 일치 (50,000원) - ",
            "5개 일치 (1,500,000원) - ", "5개 일치, 보너스 볼 일치 (30,000,000원) - ", "6개 일치 (2,000,000,000원) - ");
    private static final Ranking[] RANKINGS = {BLANK, FIFTH, FORTH, THIRD, SECOND, FIRST};
    private static final List<String> RANKINGS_STRINGS = List.of("BLANK", "FIFTH", "FORTH", "THIRD", "SECOND", "FIRST");

    @ParameterizedTest
    @CsvSource(value = {"0,true,BLANK", "0,false,BLANK", "1,true,BLANK", "1,false,BLANK", "2,true,BLANK", "2,false,BLANK",
            "3,true,FIFTH", "3,false,FIFTH", "4,true,FORTH", "4,false,FORTH", "5,true,SECOND", "5,false,THIRD", "6,false,FIRST"})
    void findRanking_성공(int corrects, boolean bonus, String expected) {
        assertThat(Ranking.findRanking(corrects, bonus)).isEqualTo(Ranking.valueOf(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"-1,true", "-1,false", "7,true", "7,false"})
    void findRanking_불가능한일치개수(int corrects, boolean bonus) {
        assertThatThrownBy(() -> Ranking.findRanking(corrects, bonus)).isInstanceOf(IllegalStateException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"6,true"})
    void findRanking_불가능한일치개수보너스(int corrects, boolean bonus) {
        assertThatThrownBy(() -> Ranking.findRanking(corrects, bonus)).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void getPrize() {
        Ranking[] rankings = Ranking.values();

        for (int i = 0; i < rankings.length; i++) {
            assertThat(rankings[i].getPrize()).isEqualTo(PRIZES.get(i));
        }
    }

    @Test
    void getResult() {
        Ranking[] rankings = Ranking.values();

        for (int i = 0; i < rankings.length; i++) {
            assertThat(rankings[i].getResult()).isEqualTo(RESULTS.get(i));
        }
    }

    @Test
    void values() {
        assertThat(Ranking.values()).isEqualTo(RANKINGS);
    }

    @Test
    void valueOf() {
        for (int i = 0; i < RANKINGS_STRINGS.size(); i++) {
            assertThat(Ranking.valueOf(RANKINGS_STRINGS.get(i))).isEqualTo(RANKINGS[i]);
        }
    }
}