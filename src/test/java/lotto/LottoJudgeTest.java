package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.lottojudge.JudgeNotConfiguredException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoJudgeTest {
    LottoJudge lottoJudge;

    @DisplayName("당첨 번호가 정해지기 전에 판정을 시도하면 예외가 발생한다.")
    @Test
    void judgeLottoBeforeConfiguration() {
        lottoJudge = new LottoJudge();

        assertThatThrownBy(() -> lottoJudge.judge(null))
                .isInstanceOf(JudgeNotConfiguredException.class);
    }
}
