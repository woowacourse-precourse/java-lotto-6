package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWinningNumberInputTest {

    private final LottoWinningNumberInput lottoWinningNumberInput = new LottoWinningNumberInput();

    @DisplayName("입력된 번호가 6개가 아니면 예외를 발생시킨다.")
    @Test
    void whenInputIsNotSixNumbers_thenThrowException() {
        String invalidInput = "1,2,3,4,5";
        assertThatThrownBy(() -> lottoWinningNumberInput.validateInputFormat(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 6개여야 합니다.");
    }

    @DisplayName("입력된 번호에 중복이 있으면 예외를 발생시킨다.")
    @Test
    void whenInputHasDuplicates_thenThrowException() {
        String duplicateInput = "1,2,3,3,4,5";
        assertThatThrownBy(() -> lottoWinningNumberInput.validateInputFormat(duplicateInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 번호가 있습니다.");
    }

    @DisplayName("정상적인 입력을 변환하면 정확한 번호 세트를 얻는다.")
    @Test
    void whenInputIsValid_thenConvertToNumberSet() {
        String validInput = "1,2,3,4,5,6";
        Set<Integer> numberSet = lottoWinningNumberInput.convertInputToSet(validInput);
        assertThat(numberSet).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("입력된 번호가 범위를 벗어나면 예외를 발생시킨다.")
    @Test
    void whenInputNumberIsOutOfRange_thenThrowException() {
        String outOfRangeInput = "0,2,3,4,5,49";
        // Assume 'validateAndConvert' method exposes both validation steps publicly.
        assertThatThrownBy(() -> lottoWinningNumberInput.convertInputToSet(outOfRangeInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 번호는 1과 45 사이여야 합니다");
    }

}
