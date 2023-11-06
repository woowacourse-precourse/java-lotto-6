package lotto.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGradeTest {
    @DisplayName("당첨될 수 있는 모든 경우의 수 테스트입니다.")
    @Test
    void findLottoGradeTest() {
        assertThat(LottoGrade.findLottoGrade(6, false))
                .isEqualTo(LottoGrade.SIX_MATCH);
        assertThat(LottoGrade.findLottoGrade(5, true))
                .isEqualTo(LottoGrade.FIVE_AND_BONUS_MATCH);
        assertThat(LottoGrade.findLottoGrade(5, false))
                .isEqualTo(LottoGrade.FIVE_MATCH);
        assertThat(LottoGrade.findLottoGrade(4, false))
                .isEqualTo(LottoGrade.FOUR_MATCH);
        assertThat(LottoGrade.findLottoGrade(4, true))
                .isEqualTo(LottoGrade.FOUR_MATCH);
        assertThat(LottoGrade.findLottoGrade(3, false))
                .isEqualTo(LottoGrade.THREE_MATCH);
        assertThat(LottoGrade.findLottoGrade(3, true))
                .isEqualTo(LottoGrade.THREE_MATCH);
        assertThat(LottoGrade.findLottoGrade(2, false))
                .isEqualTo(LottoGrade.NO_GRADE);
        assertThat(LottoGrade.findLottoGrade(2, true))
                .isEqualTo(LottoGrade.NO_GRADE);
        assertThat(LottoGrade.findLottoGrade(1, false))
                .isEqualTo(LottoGrade.NO_GRADE);
        assertThat(LottoGrade.findLottoGrade(1, true))
                .isEqualTo(LottoGrade.NO_GRADE);
        assertThat(LottoGrade.findLottoGrade(0, false))
                .isEqualTo(LottoGrade.NO_GRADE);
        assertThat(LottoGrade.findLottoGrade(0, true))
                .isEqualTo(LottoGrade.NO_GRADE);
    }
}
