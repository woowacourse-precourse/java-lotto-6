package lotto.validator;

import lotto.message.ErrorMessage;
import lotto.view.input.validator.LottoNumberInputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberInputValidatorTestView {

    private LottoNumberInputValidator validator = new LottoNumberInputValidator();

    @ParameterizedTest(name = "{index}: 숫자가 아닌 입력으로 {0}이 들어오면 예외가 발생한다.")
    @DisplayName("숫자가 아닌 다른 입력이 들어오면 예외가 발생한다.")
    @ValueSource(strings = {"asda", "안녕하세요", "中國語", "ひらがな"})
    public void parseIntException(String input) {
        // when // then
        assertThatThrownBy(() -> validator.parseInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_FORMAT.getMessage());
    }

    @Test
    @DisplayName("번호들이 1~45사이의 숫자가 아니면 예외가 발생한다.")
    public void validateLottoNumbersRange() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 46, 5, 6);
        // when // then
        assertThatThrownBy(() -> validator.validateLottoNumberRange(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }

    @Test
    @DisplayName("번호가 1~45사이의 숫자가 아니면 예외가 발생한다.")
    public void validateLottoNumberRange() {
        // given
        int number = 0;
        // when // then
        assertThatThrownBy(() -> validator.validateLottoNumberRange(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }

    @Test
    @DisplayName("로또 번호의 개수가 6이 아니면 예외가 발생한다.")
    public void validateLottoSize() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        // when // then
        assertThatThrownBy(() -> validator.validateLottoSize(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
    }

    @Test
    @DisplayName("bonus번호가 당첨금액에 포함되면 예외가 발생한다.")
    public void validateBonusNumberMatchException() {
        // given
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 1;
        // when // then
        assertThatThrownBy(() -> validator.validateBonusNumberMatch(bonusNumber,winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_MATCH.getMessage());
    }
}