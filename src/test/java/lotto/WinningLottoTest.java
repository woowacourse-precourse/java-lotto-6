package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
    private Lotto lotto;
    private Bonus bonus;

    @DisplayName("보너스 번호가 로또 당첨 번호와 중복되는 경우 예외가 발생한다.")
    @Test
    void createWithDuplicateBonusNumber(){
        lotto = new Lotto(List.of(1,2,3,4,5,6));
        bonus = Bonus.from("1");

        assertThatThrownBy(() -> WinningLotto.of(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
