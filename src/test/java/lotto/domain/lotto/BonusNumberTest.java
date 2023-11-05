package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    @ParameterizedTest
    @DisplayName("보너스 번호는 1에서 45까지의 범위에 있지 않으면 예외 발생")
    @ValueSource(ints = {-18, 0, 99, 500, 46, 40000})
    void should_Throw_Exception_For_Out_Of_Range(int input) {
        assertThatThrownBy(() -> BonusNumber.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 보너스 번호가 포함되어 있으면 true를 반환")
    @Test
    void should_Return_True_If_Bonus_Number_Is_In_WinningNumbers() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto winningNumbers = Lotto.from(numbers);

        int number = 1;
        BonusNumber bonusNumber = BonusNumber.from(number);

        // when
        boolean isMatch = bonusNumber.isMatching(winningNumbers);

        // then
        assertTrue(isMatch);
    }
}