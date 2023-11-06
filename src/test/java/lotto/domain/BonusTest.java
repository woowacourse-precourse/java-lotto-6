package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {
    @Test
    @DisplayName("보너스 번호가 숫자가 아니므로 예외가 발생한다.")
    void validateNumberFormat() throws Exception {
        //given
        String bonusNumber = "1j";
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        //when
        //then
        assertThatThrownBy(() -> new Bonus(bonusNumber, winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 당첨번호와 중복되므로 예외가 발생한다.")
    void validateDuplicate() throws Exception {
        //given
        String bonusNumber = "1";
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        //when
        //then
        assertThatThrownBy(() -> new Bonus(bonusNumber, winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 1이상 45이하 숫자가 아니므로 예외가 발생한다.")
    void validateRange() throws Exception {
        //given
        String bonusNumber1 = "0";
        String bonusNumber2 = "46";
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        //when
        //then
        assertAll(
                () -> assertThatThrownBy(() -> new Bonus(bonusNumber1, winningNumber))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new Bonus(bonusNumber2, winningNumber))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}