package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoTest {

    @DisplayName("보너스 숫자가 로또 숫자와 중복되면 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    public void duplicateBonusNumberTest(int bonusNumber) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] : 보너스 숫자는 당첨 번호와 중복될 수 없습니다");
    }

    @DisplayName("보너스 숫자 범위가 1~45 벗어나면 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    public void outOfBoundsBonusNumberTest(int bonusNumber) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] : 숫자가 1에서 45 사이의 범위를 벗어납니다.");
    }
}