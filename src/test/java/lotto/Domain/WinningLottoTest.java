package lotto.Domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @DisplayName("보너스 번호가 당첨 번호에 포함되어 있는 숫자라면 예외가 발생한다.")
    @Test
    void createWinningLottoByWinningNumbersIncludeBonusNumber() {
        Assertions.assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(6)))
                .isInstanceOf(
                        IllegalArgumentException.class);
    }
}