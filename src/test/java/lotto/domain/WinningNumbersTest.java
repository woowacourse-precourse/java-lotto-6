package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @DisplayName("당첨 번호 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void validateWinningNumbersSize() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        //when
        //then
        assertThatThrownBy(() -> {
            WinningNumbers winningNumbers = new WinningNumbers(numbers);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR] 당첨 번호 개수가 6개가 아닙니다.");
    }

    @DisplayName("당첨 번호가 하나라도 중복되면 예외가 발생한다")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}