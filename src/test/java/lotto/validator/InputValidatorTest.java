package lotto.validator;

import static lotto.exception.ErrorMessage.EMPTY;
import static lotto.exception.ErrorMessage.ENDS_WITH_DELIMITER;
import static lotto.exception.ErrorMessage.INVALID_LOTTO_NUMBER_COUNT_INPUT;
import static lotto.exception.ErrorMessage.INVALID_LOTTO_NUMBER_INPUT;
import static lotto.exception.ErrorMessage.INVALID_PURCHASE_AMOUNT;
import static lotto.validator.InputValidator.validateEmpty;
import static lotto.validator.InputValidator.validateEndsWithComma;
import static lotto.validator.InputValidator.validateLottoNumberCount;
import static lotto.validator.InputValidator.validateLottoNumberRange;
import static lotto.validator.InputValidator.validatePurchaseAmount;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


@TestInstance(Lifecycle.PER_CLASS)
@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InputValidatorTest {

    @Test
    void 입력_값이_비었을_시_예외를_던져라() {
        //given
        String input = "";

        //when, then
        assertThatThrownBy(() -> validateEmpty(input))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(EMPTY.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,3,4,5,",
            "12,32,",
            "5,4,2,15,21,32,",
            ","
    })
    void 쉼표로_끝나는_입력_값에_예외를_던져라(final String input) {
        //when, then
        assertThatThrownBy(() -> validateEndsWithComma(input))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(ENDS_WITH_DELIMITER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1500, 2100, 3100, 9500, 11200, 15100})
    void 구입금액이_1000원으로_나누어_떨어지지_않으면_예외를_던져라(final int input) {
        //when, then
        assertThatThrownBy(() -> validatePurchaseAmount(input))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(INVALID_PURCHASE_AMOUNT.getMessage());
    }

    @ParameterizedTest
    @MethodSource("invalidLottoNumberCountList")
    void 로또_번호가_6개의_숫자가_아니면_예외를_던져라(List<Integer> input) {
        assertThatThrownBy(() -> validateLottoNumberCount(input))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBER_COUNT_INPUT.getMessage());
    }

    List<List<Integer>> invalidLottoNumberCountList() {
        return Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(6, 7, 8),
                Arrays.asList(1, 2)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {46,52,0,99,-1})
    void 로또_번호가_정해진_범위를_벗어나면_예외를_던져라(final int input) {
        assertThatThrownBy(() -> validateLottoNumberRange(input))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBER_INPUT.getMessage());
    }
}
