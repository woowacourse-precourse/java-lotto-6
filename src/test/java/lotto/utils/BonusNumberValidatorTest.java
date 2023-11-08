package lotto.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberValidatorTest {

    @DisplayName("보너스 번호는 숫자여야 한다.")
    @Test
    void 보너스번호_숫자_테스팅() {
        String bonusNumber = "a";
        assertThatThrownBy(() -> BonusNumberValidator.validIsInt(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호는 당첨 번호와 중복되면 안된다.")
    @Test
    void 보너스번호_당첨번호_중복_테스팅() {
        Lotto winningNumbers = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 1;
        assertThatThrownBy(() -> BonusNumberValidator
                .validIsNotDuplicateWithWinningNumbers(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
