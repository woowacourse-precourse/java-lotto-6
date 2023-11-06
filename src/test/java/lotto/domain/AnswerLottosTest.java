package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnswerLottosTest {
    @Test
    @DisplayName("보너스 볼이 당첨 번호와 중복인 경우 예외가 발생한다.")
    void bonusBallSameLotto() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusBall bonusBall = new BonusBall(1);

        // when & then
        assertThatThrownBy(() -> new AnswerLottos(lotto, bonusBall))
                .isInstanceOf(IllegalArgumentException.class);
    }
}