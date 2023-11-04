package lotto;

import Model.BonusNumber;
import Model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @DisplayName("보너스 번호가 1~45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createBonusNumberNotBetween1And45() {
        assertThatThrownBy(() -> new BonusNumber(60))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 이미 로또 번호 중에 존재하면 예외가 발생한다.")
    @Test
    void createBonusNumberAlreadyExistInLotto() {
        Lotto lotto = new Lotto(List.of(1, 5, 13, 20, 36, 45));
        BonusNumber bonusNumber = new BonusNumber(13);
        assertThatThrownBy(() -> bonusNumber.validateAlreadyExist(lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
