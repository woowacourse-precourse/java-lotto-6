package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoNumbersTest {

    @DisplayName("보너스 번호가 1~45사이 값이 아닐때 예외가 발생한다.")
    @Test
    void createWinningLottoNumbersByOverBonusRange() {
        int bonusNum = 46;
        assertThatThrownBy(() -> new WinningLottoNumbers(new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6))),bonusNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호rk 로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningLottoNumbersByDuplicatedBonus() {
        int bonusNum = 6;
        assertThatThrownBy(() -> new WinningLottoNumbers(new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6))),6))
                .isInstanceOf(IllegalArgumentException.class);
    }

}