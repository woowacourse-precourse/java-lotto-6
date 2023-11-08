package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoAnswerTest {
    @Test
    @DisplayName("로또 당첨번호, 보너스번호 - 정상 입력")
    void normalAnswerTest() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        LottoAnswer lottoAnswer = new LottoAnswer(winningLotto, bonusNumber);

        assertThat(lottoAnswer.getWinningNumbers().getNumbers()).containsAll(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoAnswer.getBounsNumber().getValue()).isEqualTo(7);
    }

    @Test
    @DisplayName("로또 당첨번호, 보너스번호 - 상호 간 중복 입력")
    void duplicateAnswerTest() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(3);

        assertThatThrownBy(() -> new LottoAnswer(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
