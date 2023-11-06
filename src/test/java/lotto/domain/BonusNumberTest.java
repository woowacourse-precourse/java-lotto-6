package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @DisplayName("보너스번호가 우승로또와 중복되는 숫자면 예외가 발생 한다.")
    @Test
    void createBonusNumberContainsWinningNumbers() {
        assertThatThrownBy(() -> new BonusNumber(1, new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호가 1부터 45사이의 숫자가 아니면 예외가 발생 한다.")
    @Test
    void createBonusNumberOutOfRange() {
        assertThatThrownBy(() -> new BonusNumber(46, new Lotto(List.of(1,2,3,4,5,6))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}