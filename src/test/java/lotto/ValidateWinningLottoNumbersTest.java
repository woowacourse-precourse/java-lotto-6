package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.manager.LottoException;
import lotto.validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("당첨 번호 검증")
public class ValidateWinningLottoNumbersTest {
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1,3,45,32,14,21", "45,44,43,42,41,40"})
    @DisplayName("[정상처리] 당첨 번호를 검증한다.")
    void 당첨번호_검증_정상처리(String winningLottoNumbers) {
        assertThatCode(() -> Validator.validateWinningLottoNumbers(winningLottoNumbers))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,a", "1,3,4,5,6,@", "45,44,43,,11,", ",", ",1,,", ",,,,,", "2e1d"})
    @DisplayName("[예외처리] 당첨 번호가 숫자가 아니면 예외가 발생한다.")
    void 당첨번호_검증_숫자아님_예외처리(String winningLottoNumbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validator.validateWinningLottoNumbers(winningLottoNumbers))
                .withMessageContaining(LottoException.NOT_NUMBER.getErrorMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7", "12345"})
    @DisplayName("[예외처리] 당첨 번호가 6개가 아니면 예외가 발생한다.")
    void 당첨번호_검증_개수틑림_예외처리(String winningLottoNumbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validator.validateWinningLottoNumbers(winningLottoNumbers))
                .withMessageContaining(LottoException.LOTTO_NUMBERS_COUNT_OUT_OF_RANGE.getErrorMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,46", "-11,1,2,3,4,5", "46,11,23,25,53,-11"})
    @DisplayName("[예외처리] 당첨 번호가 1~45가 아니면 예외가 발생한다.")
    void 당첨번호_검증_숫자범위초과_예외처리(String winningLottoNumbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validator.validateWinningLottoNumbers(winningLottoNumbers))
                .withMessageContaining(LottoException.LOTTO_NUMBER_OUT_OF_RANGE.getErrorMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,5", "1,2,3,4,5,5"})
    @DisplayName("[예외처리] 당첨 번호의 숫자들이 중복되면 예외가 발생한다.")
    void 당첨번호_검증_숫자중복_예외처리(String winningLottoNumbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validator.validateWinningLottoNumbers(winningLottoNumbers))
                .withMessageContaining(LottoException.LOTTO_NUMBER_HAS_DUPLICATES.getErrorMessage());
    }
}
