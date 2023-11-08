package lotto.validator;

import org.junit.jupiter.api.Test;

import lotto.error.LottoErrorMessage;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;

public class ValidatorLottoNumbersTest {

    private final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 로또_번호_개수가_6개와_일치하지_않을_경우_예외발생_후_오류_식별이_가능한_메시지_발생() {
        // given
        List<Integer> givenLottoNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        // when
        assertThatThrownBy(() -> ValidatorLottoNumbers.validateNumberList(givenLottoNumbers))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE)
                .hasMessageContaining(LottoErrorMessage.INVALID_LOTTO_SIZE.getMessage());
    }

    @Test
    void 로또_번호가_중복될_경우_예외발생_후_오류_식별이_가능한_메시지_발생() {
        // given
        List<Integer> givenLottoNumbers = List.of(1, 2, 3, 4, 5, 5);
        // when
        assertThatThrownBy(() -> ValidatorLottoNumbers.validateNumberList(givenLottoNumbers))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE)
                .hasMessageContaining(LottoErrorMessage.DUPLICATED_LOTTO_NUMBERS.getMessage());
    }

    @Test
    void 입력값으로_받은_로또_번호들이_숫자가_아닐_경우_예외_발생() {
        // given
        List<String> givenLottoNumbers = List.of("1", "2", "3", "4", ",", "5");
        // when
        assertThatThrownBy(() -> ValidatorLottoNumbers.validateStringNumberList(givenLottoNumbers))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE)
                .hasMessageContaining(LottoErrorMessage.WRONG_LOTTO_NUMBER.getMessage());
    }

    @Test
    void 로또_번호_숫자_리스트가_검증이_성공할_경우_예외_미발생() {
        // given
        List<Integer> givenLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        // when
        assertThatCode(() -> ValidatorLottoNumbers.validateNumberList(givenLottoNumbers))
                //then
                .doesNotThrowAnyException();
    }

    @Test
    void 로또_번호_문자열_리스트가_검증이_성공할_경우_예외_미발생() {
        // given
        List<String> givenLottoNumbers = List.of("1", "2", "3", "4", "5");
        // when
        assertThatCode(() -> ValidatorLottoNumbers.validateStringNumberList(givenLottoNumbers))
                //then
                .doesNotThrowAnyException();
    }
}
