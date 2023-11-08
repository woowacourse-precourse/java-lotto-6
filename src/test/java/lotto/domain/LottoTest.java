package lotto.domain;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("보너스 번호가 로또 번호와 중복 되면 예외가 발생한다.")
    @Test
    void checkBonusNumberInLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        assertThatThrownBy(() -> Assertions.assertFalse(lotto.isNumberInLotto(bonusNumber)));
    }

    @DisplayName("입력한 로또의 번호 일치 개수가 다르면 예외가 발생한다.")
    @Test
    void checkMatchCount() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lottoToCompare = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> Assertions.assertEquals(lotto.calcMatchNumber(lottoToCompare), 1));
    }
}