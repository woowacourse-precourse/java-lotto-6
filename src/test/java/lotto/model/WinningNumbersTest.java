package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @Test
    @DisplayName("보너스 번호가 당첨번호와 중복이 있을 시 에러를 발생시킨다.")
    void hasDuplicatedWithWinningNumberTest() {
        // given
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 4;
        // when & then
        Assertions.assertThatThrownBy( () -> WinningNumbers.of(lotto,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 로또 숫자 범위에 맞지 않을 시 에러를 발생시킨다.")
    void validateNumberRangeTest() {
        // given
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 56;
        // when & then
        Assertions.assertThatThrownBy( () -> WinningNumbers.of(lotto,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}