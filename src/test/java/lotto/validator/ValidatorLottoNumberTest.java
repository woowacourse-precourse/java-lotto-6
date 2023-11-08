package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.stream.IntStream;
import java.util.List;
import org.junit.jupiter.api.Test;

import lotto.error.LottoErrorMessage;

class ValidatorLottoNumberTest {
    final int START_LOTTO_NUMBER = 1;
    final int END_LOTTO_NUMBER = 45;
    final int OUT_OF_RANGE_LOTTO_NUMBER = 46;
    final String OUT_OF_RANGE_LOTTO_NUMBER_STRING = "46";
    final String WRONG_LOTTO_NUMBER = "123abc";
    final IntStream LOTTO_IN_RANGE = IntStream.range(START_LOTTO_NUMBER, END_LOTTO_NUMBER + 1);
    final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 로또_번호는_1부터_45이내에_생성되어야_함_성공() {
        // when & then
        assertDoesNotThrow(() -> LOTTO_IN_RANGE
                .forEach(ValidatorLottoNumber::validate));
    }

    @Test
    void 로또_번호_범위_밖에서_생성될_경우_오류() {
        assertThatThrownBy(() -> ValidatorLottoNumber.validate(OUT_OF_RANGE_LOTTO_NUMBER))
                .hasMessageContaining(ERROR_MESSAGE)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_당첨_입력값이_숫자이고_1부터_45일_경우_성공() {
        // then
        assertDoesNotThrow(() -> LOTTO_IN_RANGE
                // given
                .mapToObj(String::valueOf)
                // when
                .forEach(ValidatorLottoNumber::validateString));
    }

    @Test
    void 로또_당첨_입력값이_숫자가_아닐경우_예외발생_후_오류_식별이_가능한_메시지_발생() {
        assertThatThrownBy(() -> ValidatorLottoNumber.validateString(WRONG_LOTTO_NUMBER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE)
                .hasMessageContaining(LottoErrorMessage.WRONG_LOTTO_NUMBER.getMessage());
    }

    @Test
    void 로또_당첨_입력값이_숫자이고_범위_밖에서_생성되면_예외발생_후_오류_식별이_가능한_메시지_발생() {
        assertThatThrownBy(() -> ValidatorLottoNumber.validateString(OUT_OF_RANGE_LOTTO_NUMBER_STRING))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE)
                .hasMessageContaining(LottoErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @Test
    void 보너스_번호의_입력값이_당첨_번호와_겹칠경우_예외발생_후_오류_식별이_가능한_메시지_발생() {
        // given
        List<Integer> winnerNumber = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = "1";

        // when
        assertThatThrownBy(()-> ValidatorLottoNumber.validateBonusNumber(bonusNumber, winnerNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE)
                .hasMessageContaining(LottoErrorMessage.ALREADY_WINNING_NUMBER.getMessage());

    }
}
