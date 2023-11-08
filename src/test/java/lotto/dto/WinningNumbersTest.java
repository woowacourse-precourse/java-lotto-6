package lotto.dto;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {
    @DisplayName("당첨 번호와 보너스 번호의 중복을 검증한다.")
    @Test
    void checkWinningAndBonusNumbersDuplication() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(4);

        assertThatThrownBy(() -> new WinningNumbers(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}