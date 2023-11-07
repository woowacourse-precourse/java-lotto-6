package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static lotto.constant.ExceptionMessage.INVALID_BONUS_NUMBER_CONTAIN_EXCEPTION;
import static lotto.constant.ExceptionMessage.INVALID_BONUS_NUMBER_RANGE_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {
    @DisplayName("보너스 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, 47, 48, 49, 50})
    void validateRange(int bonusNumber) {
        // given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        // when, then
        assertThatThrownBy(() -> new WinningNumber(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_BONUS_NUMBER_RANGE_EXCEPTION.getMessage());
    }

    @DisplayName("보너스 번호가 로또 번호와 중복 된다면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void validateContain(int bonusNumber) {
        // given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        // when, then
        assertThatThrownBy(() -> new WinningNumber(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_BONUS_NUMBER_CONTAIN_EXCEPTION.getMessage());
    }
}
