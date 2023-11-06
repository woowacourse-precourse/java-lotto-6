package lotto.model.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {

    @Test
    @DisplayName("순위 찾기 1등")
    public void findRank1() {
        int correctCount = 6;
        boolean hasBonus = false;

        Assertions.assertThat(LottoRank.findRank(correctCount, hasBonus))
                .isEqualTo(LottoRank.FIRST_PLACE);
    }

    @Test
    @DisplayName("순위 찾기 2등")
    public void findRank2() {
        int correctCount = 5;
        boolean hasBonus = true;

        Assertions.assertThat(LottoRank.findRank(correctCount, hasBonus))
                .isEqualTo(LottoRank.SECOND_PLACE);
    }

    @Test
    @DisplayName("순위 찾기 3등")
    public void findRank3() {
        int correctCount = 5;
        boolean hasBonus = false;

        Assertions.assertThat(LottoRank.findRank(correctCount, hasBonus))
                .isEqualTo(LottoRank.THIRD_PLACE);
    }

    @Test
    @DisplayName("순위 찾기 4등")
    public void findRank4() {
        int correctCount = 4;
        boolean hasBonus = false;

        Assertions.assertThat(LottoRank.findRank(correctCount, hasBonus))
                .isEqualTo(LottoRank.FOURTH_PLACE);
    }

    @Test
    @DisplayName("순위 찾기 5등")
    public void findRank5() {
        int correctCount = 3;
        boolean hasBonus = false;

        Assertions.assertThat(LottoRank.findRank(correctCount, hasBonus))
                .isEqualTo(LottoRank.FIFTH_PLACE);
    }

    @Test
    @DisplayName("순위 찾기 꽝 2개")
    public void findRankNoLuck2() {
        int correctCount = 2;
        boolean hasBonus = false;

        Assertions.assertThat(LottoRank.findRank(correctCount, hasBonus))
                .isEqualTo(LottoRank.NO_LUCK);
    }

    @Test
    @DisplayName("순위 찾기 꽝 1개")
    public void findRankNoLuck1() {
        int correctCount = 1;
        boolean hasBonus = false;

        Assertions.assertThat(LottoRank.findRank(correctCount, hasBonus))
                .isEqualTo(LottoRank.NO_LUCK);
    }

    @Test
    @DisplayName("순위 찾기 꽝 0개")
    public void findRankNoLuck0() {
        int correctCount = 0;
        boolean hasBonus = false;

        Assertions.assertThat(LottoRank.findRank(correctCount, hasBonus))
                .isEqualTo(LottoRank.NO_LUCK);
    }
}