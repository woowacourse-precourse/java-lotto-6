package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @DisplayName("우승 번호의 당첨 번호와 보너스 번호가 중복되는 경우 예외가 발생한다.")
    @Test
    void 우승_번호_중복_테스트() {
        BonusNumber bonusNumber = new BonusNumber("1");
        Lotto lotto = new Lotto("1,2,3,4,5,6");

        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }



}