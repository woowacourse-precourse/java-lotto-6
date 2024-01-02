package lotto.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @Test
    void 보너스_숫자_범위_유효성_검사_테스트() {
        int bonusNumber = 47;

        Assertions.assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_숫자_유효성_검사_테스트() {
        int bonusNumber = 1;

        Assertions.assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
