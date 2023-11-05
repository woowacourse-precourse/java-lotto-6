package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("로또 당첨 번호와 보너스 번호가 같을 경우 예외가 발생한다.")
    void createWinningLottoByDuplicateNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(1);

        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("당첨 번호에 입력받은 번호가 존재할 경우 true를 반환한다.")
    void containNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        int number = 1;

        boolean isContain = winningLotto.isContain(number);

        assertThat(isContain).isTrue();
    }

    @Test
    @DisplayName("당첨 번호에 입력받은 번호가 존재하지 않을 경우 false를 반환한다.")
    void notContainNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        int number = 35;

        boolean isContain = winningLotto.isContain(number);

        assertThat(isContain).isFalse();
    }
}
