package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    @DisplayName("범위에 벗어난 보너스번호가 입력되면 예외가 발생한다.")
    @Test
    void createBonusNumberWithInvalidRangeNumber() {
        assertThatThrownBy(() -> new BonusNumber("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("갯수에 맞지 않는 보너스번호가 입력되면 예외가 발생한다.")
    @Test
    void createBonusNumberWithNumbers() {
        assertThatThrownBy(() -> new BonusNumber("1,2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자가 보너스번호로 입력되면 예외가 발생한다.")
    @Test
    void createBonusNumberWithCharacter() {
        assertThatThrownBy(() -> new BonusNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("공백이 포함되면 예외가 발생한다.")
    @Test
    void createBonusNumberWithBlank() {
        assertThatThrownBy(() -> new BonusNumber("1 "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 수와 중복되는 경우 예외가 발생한다.")
    @Test
    void createBonusNumberWithDuplicate() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber("1");

        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
