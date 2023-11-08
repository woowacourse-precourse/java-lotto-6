package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @DisplayName("보너스 번호의 숫자 범위가 1~45가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1})
    void createLottoByOutOfRangeNumber(int bonus) {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new WinningLotto(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호가 일치하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void createWinningLottoByDuplicatedBonusNumber(int bonus) {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new WinningLotto(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호가 일치하지 않으면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {7, 45})
    void createWinningLotto(int bonus) {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThatCode(() -> new WinningLotto(lotto, bonus))
                .doesNotThrowAnyException();
    }
}
