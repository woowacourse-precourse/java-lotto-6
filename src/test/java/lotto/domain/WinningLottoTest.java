package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("보너스 번호가 당첨번호와 중복되면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicatedBonusNumber() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new WinningLotto(numbers, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 범위내의 숫자가 아니라면 예외가 발생한다.")
    @Test
    void createWinningLottoByHighBonusNumber() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new WinningLotto(numbers, 46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}