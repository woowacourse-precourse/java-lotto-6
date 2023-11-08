package lotto;

import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {

    @Test
    @DisplayName("보너스번호는 당첨번호 6개와 중복된 번호를 가질 수 없다.")
    void createBonusNumber_Number_throwsIllegalArgumentException() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(6);

        // when & then
        assertThatThrownBy(() -> new WinningNumber(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

