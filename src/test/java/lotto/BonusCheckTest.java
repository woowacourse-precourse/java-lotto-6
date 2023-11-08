package lotto;

import lotto.model.Checker;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
class BonusCheckTest {
    @DisplayName("당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.")
    @Test
    void duplicateTestLottoWithBonus() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonus = 6;
        assertThatThrownBy(() -> new Checker(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 중복되지 않는 로또 번호여야 합니다.");
    }

}
