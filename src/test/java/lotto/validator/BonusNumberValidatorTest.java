package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberValidatorTest {
    private final Lotto winnerLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

    @DisplayName("보너스번호가 로또번호 범위 밖일 때 예외처리한다.")
    @Test
    void outOfRangeBonusNumber() {
        assertThatThrownBy(() -> {
            BonusNumberValidator.validate(winnerLotto, 46);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨번호와 중복 될 때 예외처리한다.")
    @Test
    void winnerNumberContainsBonusNumber() {
        assertThatThrownBy(() -> {
            BonusNumberValidator.validate(winnerLotto, 1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
