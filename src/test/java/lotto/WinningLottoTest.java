package lotto;

import domain.Lotto;
import domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    private final WinningLotto winningLotto = WinningLotto.getInstance();

    @DisplayName("당첨번호와 보너스번호가 중복되면 예외가 발생한다.")
    @Test
    void createBounsNumberByDuplicateWinningNumber() {
        winningLotto.setNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThatThrownBy(() -> winningLotto.setBonusNumber(1))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
