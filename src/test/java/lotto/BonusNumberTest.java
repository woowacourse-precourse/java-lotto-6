package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    @Test
    @DisplayName("보너스 번호가 1부터 45 사이의 숫자인지 검증한다.")
    void validateByRangeOfNumber() {
        assertThatThrownBy(() -> new BonusNumber("47"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되는지 검증한다.")
    void validateByDuplicate() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber("3");
        assertThatThrownBy(() -> BonusNumber.validateDuplicate(lotto.getNumbers(), bonusNumber.getBonusNumber()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
