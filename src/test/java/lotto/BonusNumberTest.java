package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    @DisplayName("보너스 번호가 1~45의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createBonusNumberByOutOfRange() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new BonusNumber(46, lotto.numbers()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호랑 중복되면 예외가 발생한다.")
    @Test
    void createDuplicateBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new BonusNumber(5, lotto.numbers()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
