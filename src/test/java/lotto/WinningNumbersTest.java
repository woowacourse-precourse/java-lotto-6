package lotto;

import lotto.controller.InputController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {
    public InputController inputController = new InputController();

    @DisplayName("당첨 숫자의 개수가 6이 아니면 예외가 발생한다.")
    @Test
    void createWinningNumbersByOverSize() {
        //given OverSizeNumbers

        //when validateLength

        //then
        assertThatThrownBy(() -> inputController.validateLength("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 숫자의 범위가 1 ~ 45를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46})
    void createWinningNumbersByInvalidRange(int invalidRangeNumber) {
        //given invalidRangeNumber

        //when validateNumberRange

        //then
        assertThatThrownBy(() -> inputController.validateNumberRange(invalidRangeNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 숫자가 중복되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1,10,20,30,40,45})
    void createWinningNumbersByDuplicatedNumbers(int duplicatedNumber) {
        //given duplicatedNumber

        //when validateNumberDuplication

        //then
        assertThatThrownBy(() -> inputController.validateNumberDuplication(duplicatedNumber, List.of(1,10,20,30,40,45)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}