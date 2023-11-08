package lotto.domain;

import lotto.util.LottoGameUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class WinningStatisticTest {

    @Test
    @DisplayName("당첨 통계 객체 생성 성공 케이스")
    void 당첨_통계_객체_생성_성공() {
        assertThat(WinningStatistic.from(LottoGameUtil.LOTTO_SCORES)).isInstanceOf(WinningStatistic.class);
    }

    @Test
    @DisplayName("당첨 통계 View 성공 케이스")
    void 당첨_통계_VIEW_성공() {
        assertThatCode(() -> WinningStatistic.from(LottoGameUtil.LOTTO_SCORES).view(3))
                .doesNotThrowAnyException();
    }
}