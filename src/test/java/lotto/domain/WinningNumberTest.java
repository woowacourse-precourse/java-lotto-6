package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.lotto.BonusDuplicateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    @DisplayName("로또번호와 보너스 번호가 같으면 예외가 발생한다.")
    @Test
    void dupulicateNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.of(5);
        assertThatThrownBy(() -> new WinningNumber(lotto, bonusNumber))
                .isInstanceOf(BonusDuplicateException.class)
                .hasMessage("보너스 번호는 로또와 다른 번호로 입력해주세요.");
    }
}