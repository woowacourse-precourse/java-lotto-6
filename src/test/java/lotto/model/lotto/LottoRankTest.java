package lotto.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoRankTest {
    @Test
    void 일치_개수가_6개이고_보너스_번호가_틀린_경우_1등이다() {
        int count = 6;
        boolean bonus = false;
        assertThat(LottoRank.of(count, bonus)).isEqualTo(LottoRank.FIRST);
    }

    @Test
    void 일치_개수가_5개이고_보너스_번호가_일치하는_경우_2등이다() {
        int count = 5;
        boolean bonus = true;
        assertThat(LottoRank.of(count, bonus)).isEqualTo(LottoRank.SECOND);
    }

    @Test
    void 일치_개수가_5개이고_보너스_번호가_틀린_경우_3등이다() {
        int count = 5;
        boolean bonus = false;
        assertThat(LottoRank.of(count, bonus)).isEqualTo(LottoRank.THIRD);
    }

    @Test
    void 일치_개수가_4개이고_보너스_번호가_일치하는_경우_4등이다() {
        int count = 4;
        boolean bonus = true;
        assertThat(LottoRank.of(count, bonus)).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    void 일치_개수가_4개이고_보너스_번호가_틀린_경우_4등이다() {
        int count = 4;
        boolean bonus = false;
        assertThat(LottoRank.of(count, bonus)).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    void 일치_개수가_3개이고_보너스_번호가_일치하는_경우_5등이다() {
        int count = 3;
        boolean bonus = true;
        assertThat(LottoRank.of(count, bonus)).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    void 일치_개수가_3개이고_보너스_번호가_틀린_경우_5등이다() {
        int count = 3;
        boolean bonus = false;
        assertThat(LottoRank.of(count, bonus)).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    void 일치_개수가_2개이고_보너스_번호가_일치하는_경우_등수가_없다() {
        int count = 2;
        boolean bonus = true;
        assertThat(LottoRank.of(count, bonus)).isEqualTo(LottoRank.NONE);
    }

    @Test
    void 일치_개수가_2개이고_보너스_번호가_틀린_경우_등수가_없다() {
        int count = 2;
        boolean bonus = false;
        assertThat(LottoRank.of(count, bonus)).isEqualTo(LottoRank.NONE);
    }

    @Test
    void 일치_개수가_1개이고_보너스_번호가_일치하는_경우_등수가_없다() {
        int count = 1;
        boolean bonus = true;
        assertThat(LottoRank.of(count, bonus)).isEqualTo(LottoRank.NONE);
    }

    @Test
    void 일치_개수가_1개이고_보너스_번호가_틀린_경우_등수가_없다() {
        int count = 1;
        boolean bonus = false;
        assertThat(LottoRank.of(count, bonus)).isEqualTo(LottoRank.NONE);
    }

    @Test
    void 일치_개수가_0개이고_보너스_번호가_일치하는_경우_등수가_없다() {
        int count = 0;
        boolean bonus = true;
        assertThat(LottoRank.of(count, bonus)).isEqualTo(LottoRank.NONE);
    }

    @Test
    void 일치_개수가_0개이고_보너스_번호가_틀린_경우_등수가_없다() {
        int count = 0;
        boolean bonus = false;
        assertThat(LottoRank.of(count, bonus)).isEqualTo(LottoRank.NONE);
    }
}