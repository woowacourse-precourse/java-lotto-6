package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    @DisplayName("로또에 보너스 넘버가 없으면, 확인시 False 반환")
    @Test
    void bonusNumberTest_1() {
        BonusNumber bonusNumber = new BonusNumber(7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(bonusNumber.checkLottoContainBonusNumber(lotto)).isFalse();
    }

    @DisplayName("로또에 보너스 넘버가 있으면, 확인시 True 반환")
    @Test
    void bonusNumberTest_2() {
        BonusNumber bonusNumber = new BonusNumber(6);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(bonusNumber.checkLottoContainBonusNumber(lotto)).isTrue();
    }

    @DisplayName("1~45 이외의 숫자로 보너스 넘버를 만들면 에러가 발생한다.")
    @Test
    void bonusNumberErrorTest() {
        assertThatThrownBy(() -> new BonusNumber(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BonusNumber(46)).isInstanceOf(IllegalArgumentException.class);
    }
}
