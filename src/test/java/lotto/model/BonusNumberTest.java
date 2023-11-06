package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @DisplayName("입력 받은 보너스 번호가 당첨 번호와 중복되는 경우 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        BonusNumber bonusNumber = new BonusNumber(1);
        Lotto winningNumbers = LottoGenerator.createLotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> bonusNumber.validateIsDuplicate(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

}