package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningTest {
    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 개수가 다를 경우 예외가 발생한다.")
    @Test
    void testVerifyNumbersCountException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Winning(List.of(1, 2, 3));
        });
    }

    @DisplayName("당첨 번호가 범위를 벗어 났을때 예외가 발생한다.")
    @Test
    void testVerifyNumbersRangeException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Winning(List.of(46, 1, 2, 3, 4, 5));
        });
    }

    @DisplayName("보너스 번호가 범위를 벗어 났을때 예외가 발생한다.")
    @Test
    void testVerifyBonusNumberRangeException() {
        Winning winning = new Winning(List.of(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 47;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            winning.setBonusNumber(bonusNumber);
        });
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
    @Test
    void testVerifyBonusNumberDuplicateException() {
        Winning winning = new Winning(List.of(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 6;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            winning.setBonusNumber(bonusNumber);
        });
    }
}