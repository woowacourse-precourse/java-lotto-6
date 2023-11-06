package lotto.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinNumberTest {

    @DisplayName("로또 번호와 보너스 번호가 중복되면 예외가 발생한다..")
    @Test
    void createLottoByOverSize() {

        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 1;

        // when & then
        assertThatThrownBy(() -> new WinNumber(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1 ~ 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByNotInRange() {

        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 46;

        // when & then
        assertThatThrownBy(() -> new WinNumber(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}