package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoNumberTest {
    private Lotto testLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("로또 번호와 중복된 값을 보너스 번호로 입력하면 예외가 발생한다.")
    @Test
    void BonusNumberIsAlreadyInLottoNumbersTest() {
        assertThatThrownBy(() -> WinningLottoNumber.of(testLotto, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위를 벗어나는 수를 보너스 번호로 입력하면 예외가 발생한다.")
    @Test
    void BonusNumberIsNotInRangeTest() {
        assertThatThrownBy(() -> WinningLottoNumber.of(testLotto, 46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}