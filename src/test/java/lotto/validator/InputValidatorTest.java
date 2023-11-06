package lotto.validator;

import static lotto.constant.ErrorMessageConstant.LOTTO_NUMBER_INPUT_ERROR_MESSAGE;
import static lotto.constant.ErrorMessageConstant.LOTTO_NUMBER_SIZE_ERROR_MESSAGE;
import static lotto.constant.ErrorMessageConstant.LOTTO_PRICE_INPUT_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    @Test
    @DisplayName("가격을 0으로 입력")
    void 가격_0_입력() {
        assertThatThrownBy(() -> InputValidator.validateLottoPriceInput("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_PRICE_INPUT_ERROR_MESSAGE.getErrorMessage());
    }

    @Test
    @DisplayName("가격을 11100으로 입력")
    void 가격_11100_입력() {
        assertThatThrownBy(() -> InputValidator.validateLottoPriceInput("11100"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_PRICE_INPUT_ERROR_MESSAGE.getErrorMessage());
    }

    @Test
    @DisplayName("가격을 11000으로 입력")
    void 가격_11000_입력() {
        int result = InputValidator.validateLottoPriceInput("11000");
        assertThat(result).isEqualTo(11);
    }

    @Test
    @DisplayName("5개의 숫자 입력")
    void _5개_숫자_입력() {
        assertThatThrownBy(() -> InputValidator.validateLottoPriceInput("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_SIZE_ERROR_MESSAGE.getErrorMessage());
    }

    @Test
    @DisplayName("6개 숫자 입력, 그 중 46입력")
    void _6개_숫자_입력_46_입력() {
        assertThatThrownBy(() -> InputValidator.validateLottoPriceInput("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_INPUT_ERROR_MESSAGE.getErrorMessage());
    }

    @Test
    @DisplayName("6개 숫자 입력")
    void _6개_숫자_입력() {
        List<Integer> result = InputValidator.validateLottoNumberInput("1,2,3,4,5,6");
        assertThat(result).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("보너스 숫자 46 입력")
    void 보너스_숫자_46_입력() {
        assertThatThrownBy(() -> InputValidator.validateBonusNumberInput("46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_INPUT_ERROR_MESSAGE.getErrorMessage());
    }

    @Test
    @DisplayName("보너스 숫자 45 입력")
    void 보너스_숫자_45_입력() {
        int result = InputValidator.validateBonusNumberInput("45");
        assertThat(result).isEqualTo(45);
    }
}