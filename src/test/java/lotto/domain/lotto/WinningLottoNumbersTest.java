package lotto.domain.lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoNumbersTest {

    private List<Integer> numbers;

    @BeforeEach
    void setup() {
        numbers = List.of(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("보너스 번호가 당첨 번호에 포함된다면 예외가 발생한다.")
    @Test
    void winningNumbersIncludeBonusNumber() {
        // given
        int bonusNumber = 3;

        // when & then
        Assertions.assertThatThrownBy(() -> new WinningLottoNumbers(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionMessages.DUPLICATED_BONUS_NUMBER.getMessage());
    }

    @DisplayName("보너스 번호가 당첨 번호에 포함되지 않는다면 예외가 발생하지 않는다.")
    @Test
    void winningNumbersExcludeBonusNumber() {
        // given
        int bonusNumber = 7;

        // when & then
        Assertions.assertThatCode(() -> new WinningLottoNumbers(numbers, bonusNumber))
                .doesNotThrowAnyException();
    }

}
