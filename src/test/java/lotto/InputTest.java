package lotto;

import lotto.input.Input;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputTest {

    public static final List<Integer> TEST_WIN_NUMS = List.of(6, 7, 8, 9, 10, 11);

    @Test
    void validateWinNumsInput_정상입력() {
        String input = "1,2,3,4,5,6";

        List<Integer> result = Input.validateWinNumsInput(input);

        assertThat(result).contains(1, 2, 3, 4, 5, 6);
        assertThat(result).size().isEqualTo(6);
    }

    @Test
    void validateWinNumsInput_잘못된_입력타입_예외() {
        assertThatThrownBy(() -> Input.validateWinNumsInput("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateWinNumsInput_6개_초과_입력_예외() {
        assertThatThrownBy(() -> Input.validateWinNumsInput("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateWinNumsInput_6개_미만_입력_예외() {
        assertThatThrownBy(() -> Input.validateWinNumsInput("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateWinNumsInput_45초과_입력_예외() {
        assertThatThrownBy(() -> Input.validateWinNumsInput("1,2,3,4,46,45"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateWinNumsInput_1미만_입력_예외() {
        assertThatThrownBy(() -> Input.validateWinNumsInput("1,2,3,0,4,45"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateWinNumsInput_중복_입력_예외() {
        assertThatThrownBy(() -> Input.validateWinNumsInput("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"1, 1", "2, 2", "5, 5", "15, 15", "45, 45"})
    void validateBonusNumInput_정상입력(String input, int answer) {
        int result = Input.validateBonusNumInput(input, TEST_WIN_NUMS);

        assertThat(result).isEqualTo(answer);
    }

    @Test
    void validateBonusNumInput_잘못된_입력타입_예외() {
        assertThatThrownBy(() -> Input.validateBonusNumInput("abc", TEST_WIN_NUMS))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBonusNumInput_1미만_입력_예외() {
        assertThatThrownBy(() -> Input.validateBonusNumInput("0", TEST_WIN_NUMS))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBonusNumInput_45초과_입력_예외() {
        assertThatThrownBy(() -> Input.validateBonusNumInput("46", TEST_WIN_NUMS))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBonusNumInput_중복_입력_예외() {
        assertThatThrownBy(() -> Input.validateBonusNumInput("6", TEST_WIN_NUMS))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"1000, 1000", "2000, 2000", "8000, 8000", "10000, 10000", "150000, 150000"})
    void validatePriceInput_정상입력(String input, int answer) {
        int result = Input.validatePriceInput(input);

        assertThat(result).isEqualTo(answer);
    }

    @Test
    void validatePriceInput_잘못된_입력타입_예외() {
        assertThatThrownBy(() -> Input.validatePriceInput("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validatePriceInput_1000으로_나누어_떨어지지_않는_입력_예외() {
        assertThatThrownBy(() -> Input.validatePriceInput("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}