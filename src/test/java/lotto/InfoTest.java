package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.constant.Grade;
import lotto.model.Info;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InfoTest {
    @DisplayName("당첨 통계 반영 테스트")
    @Test
    void 통계_반영에_대한_테스트() {
        Info info = new Info();
        info.addStatistic(Grade.FIRST_GRADE);
        info.addStatistic(Grade.SECCOND_GRADE);
        info.addStatistic(Grade.FIFTH_GRADE);
        info.addStatistic(Grade.FIRST_GRADE);

        assertThat(info.getStatistic()).isEqualTo(new int[]{0, 2, 1, 0, 0, 1});
    }

    @DisplayName("당첨금 합계 테스트")
    @Test
    void 당첨급_합계_집계_테스트() {
        Info info = new Info();
        info.addStatistic(Grade.FIRST_GRADE);
        info.addStatistic(Grade.SECCOND_GRADE);
        info.addStatistic(Grade.FIFTH_GRADE);
        info.addStatistic(Grade.FIRST_GRADE);

        assertThat(info.getRewards()).isEqualTo(4030005000L);
    }
}
