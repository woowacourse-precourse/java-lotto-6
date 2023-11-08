package lotto;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.WinningLotto;
import lotto.view.InputMoneySpentOnLottoView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FormatTest {
    @DisplayName("입력된 구입 금액이 0보다 크고 1000의 배수인 숫자가 아닐 때 예외가 발생한다.")
    @Test
    void userMoneyFormat() {
        assertThatThrownBy(() -> new InputMoneySpentOnLottoView().validate("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
