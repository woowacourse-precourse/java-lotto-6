package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
    @DisplayName("당첨 로또 생성 테스트")
    @Test
    void createWinningLotto() {
        assertThatCode(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7))
                .doesNotThrowAnyException();
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicateNumber() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
