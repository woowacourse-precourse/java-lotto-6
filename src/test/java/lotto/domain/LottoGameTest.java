package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGameTest {
    @DisplayName("보너스 번호가 1에서 45 사이의 숫자가 아닐 때 예외가 발생한다.")
    @Test
    void enterWrongRangeBonusNumber(){
        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 48;

        assertThatThrownBy(() -> new LottoGame(winningNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 때 예외가 발생한다.")
    @Test
    void enterDuplicateBonusNumber(){
        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 1;

        assertThatThrownBy(() -> new LottoGame(winningNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
