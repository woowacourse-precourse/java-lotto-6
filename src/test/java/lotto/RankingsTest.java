package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankingsTest {

    @DisplayName("맞춘 로또 번호 개수에 따른 랭킹을 보여준다")
    @Test
    void 맞춘_개수에_따른_랭킹() {
        Integer firstRank = 6;
        Integer secondRank = 5;
        Integer thirdRank = 5;
        Integer fourthRank = 4;
        Integer fifthRank = 3;
        Integer[] Nothing = new Integer[]{2, 1, 0};

        assertThat(Rankings.getRanking(firstRank, false))
                .isEqualTo(Rankings.FIRST);

        assertThat(Rankings.getRanking(secondRank, true))
                .isEqualTo(Rankings.SECOND);

        assertThat(Rankings.getRanking(thirdRank, false))
                .isEqualTo(Rankings.THIRD);

        assertThat(Rankings.getRanking(fourthRank, false))
                .isEqualTo(Rankings.FOURTH);

        assertThat(Rankings.getRanking(fifthRank, false))
                .isEqualTo(Rankings.FIFTH);

        for(int i = 0; i < Nothing.length; i++) {
            assertThat(Rankings.getRanking(Nothing[i], false))
                    .isEqualTo(Rankings.NOTHING);
        }
    }
}
