package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
    @DisplayName("보너스 번호가 당첨 로또와 중복되면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), new BonusNumber("6")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createWinningLottoByRangeOverBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), new BonusNumber("46")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
