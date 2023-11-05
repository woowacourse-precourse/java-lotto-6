package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.view.message.Error;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {

    private WinningNumber winningNumber;

    @BeforeEach
    public void setUp() {
        winningNumber = WinningNumber.create("3,5,13,43,22,42");
    }

    @DisplayName("보너스 번호가 정수가 아닌 경우 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "c", "0.3"})
    public void 정수가_아닌_경우_예외처리(String input) {
        //when+then
        assertThatThrownBy(() -> {
            BonusNumber.create(input, winningNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.BONUS_NUMBER_NOT_INTEGER.getMessage());
    }

    @DisplayName("보너스 번호가 1에서 45 사이의 정수가 아닌 경우 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"-2", "0", "46"})
    public void 범위를_벗어난_경우_예외처리(String input) {
        //when+then
        assertThatThrownBy(() -> {
            BonusNumber.create(input, winningNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.BONUS_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되는 경우 에러를 발생시킨다.")
    @Test
    public void 당첨번호와_중복되는_경우_예외처리() {
        //when
        assertThatThrownBy(() -> {
            winningNumber.getWinningNumbers().forEach((number) -> {
                BonusNumber.create(String.valueOf(number), winningNumber);
            });
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.BONUS_NUMBER_DUPLICATE_WITH_WINNINGNUMBER.getMessage());
    }
}
