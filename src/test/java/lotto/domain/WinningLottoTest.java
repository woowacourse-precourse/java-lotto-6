package lotto.domain;

import lotto.domain.lotto.Lotto;
import lotto.domain.roulette.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WinningLottoTest {
    @Test
    @DisplayName("보너스번호 입력 시, 당첨번호에 포함된 숫자를 입력한 경우 예외가 발생한다.")
    public void inputBonusNumberTest() throws Exception {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 3;

        // when
        // then
        Assertions.assertThatThrownBy(() -> WinningLotto.of(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨번호에 포함된 숫자입니다. 다시 입력해주세요.");
    }

    @Test
    @DisplayName("보너스번호 입력 시, 1~45까지의 범위 외의 숫자일 경우 예외가 발생한다.")
    public void inputBonusNumberRangeTest() throws Exception {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 99;

        // when
        // then
        Assertions.assertThatThrownBy(() -> WinningLotto.of(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1부터 45 이내의 숫자만 입력해주세요.");
    }
}
