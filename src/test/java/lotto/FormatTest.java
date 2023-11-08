package lotto;

import lotto.view.InputBonusNumberView;
import lotto.view.InputMoneySpentOnLottoView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FormatTest {
    @DisplayName("입력된 구입 금액이 0보다 크고 1000의 배수인 숫자가 아닐 때 예외가 발생한다.")
    @Test
    void userMoneyFormat() {
        assertThatThrownBy(() -> new InputMoneySpentOnLottoView().validate("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호는 6개의 1자리수 또는 2자리수인 숫자가 아닐 때 예외가 발생한다.")
    @Test
    void userLottoNumberFormat() {
        assertThatThrownBy(() -> new InputMoneySpentOnLottoView().validate("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호는 1자리수 또는 2자리수인 숫자가 아닐 때 예외가 발생한다.")
    @Test
    void userBonusNumberFormat() {
        assertThatThrownBy(() -> new InputBonusNumberView().validate("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
