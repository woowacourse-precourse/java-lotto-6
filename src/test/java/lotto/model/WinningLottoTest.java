package lotto.model;

import static lotto.utils.LottoException.DUPLICATED_BONUS_NUMBER;
import static lotto.utils.LottoException.LESS_THAN_MINIMUM_LOTTO_NUMBER;
import static lotto.utils.LottoException.MORE_THAN_MAXIMUM_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
    @DisplayName("보너스 번호가 1보다 작은 숫자라면 예외가 발생한다.")
    @Test
    void createWinningLottoByLessMinimum() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 0;

        //when ,then
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LESS_THAN_MINIMUM_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("보너스 번호가 45보다 큰 숫자라면 예외가 발생한다.")
    @Test
    void createWinningLottoByOverMaximum() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 46;

        //when ,then
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MORE_THAN_MAXIMUM_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("보너스 번호가 로또 번호와 중복된 숫자라면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicatedBonusNumber() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 1;

        //when ,then
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_BONUS_NUMBER.getMessage());
    }
}
