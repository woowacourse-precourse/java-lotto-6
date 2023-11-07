package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {
    @DisplayName("당첨 번호에 보너스 번호가 포함되면 예외가 발생한다.")
    @Test
    void contains() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(6);
        assertThatThrownBy(() -> new WinningNumber(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
