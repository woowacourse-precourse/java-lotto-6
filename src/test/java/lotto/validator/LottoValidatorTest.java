package lotto.validator;

import static lotto.exception.Exception.DUPLICATE_WINNING_NUMBER;
import static lotto.exception.Exception.WINNING_NUMBERS_SIZE_SHOULD_BE_SIX;
import static lotto.validator.LottoValidator.validate;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoValidatorTest {
    @DisplayName("당첨번호 리스트의 크기가 6이 아닌 경우 예외가 발생하는가.")
    @Test
    void validateWinningNumbersByOverSize() {
        assertThatThrownBy(() -> validate(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WINNING_NUMBERS_SIZE_SHOULD_BE_SIX.getMessage());
    }

    @DisplayName("당첨번호 리스트에 중복된 숫자가 있는 경우 예외가 발생하는가.")
    @Test
    void validateWinningNumbersByDuplication() {
        int sameNumber = 10;

        assertThatThrownBy(() -> validate(List.of(1, 2, 3, 4, sameNumber, sameNumber)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_WINNING_NUMBER.getMessage());
    }
}
