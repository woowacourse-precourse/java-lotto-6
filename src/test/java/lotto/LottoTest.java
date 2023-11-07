package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private static final int BONUS_NUM = 6;
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

    @DisplayName("로또 번호 안에 1 ~ 45 사이의 숫자가 아닌 수가 있다면 예외가 발생한다.")
    @Test
    void createLottoByRangeOfNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 555)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 안에 보너스 번호와 동일한 번호가 있다면 예외가 발생한다.")
    @Test
    void createBonusNumberInLotto() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)).bonusValidate(BONUS_NUM))
                .isInstanceOf(IllegalArgumentException.class);
    }
}