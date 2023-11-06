package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import lotto.manager.LottoException;
import lotto.validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("보너스 번호 검증")
public class ValidateBonusNumberTest {
    private static final List<Integer> WINNING_LOTTO_NUMBERS = List.of(1, 2, 3, 4, 5, 6);

    @ParameterizedTest
    @ValueSource(ints = {7, 9, 22, 35, 45})
    @DisplayName("[정상처리] 보너스 번호를 검증합니다.")
    void 보너스번호_검증_정상처리() {
        assertThatCode(() -> Validator.validateBonusNumber(7, WINNING_LOTTO_NUMBERS))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {-100, -1, 0, 46, 100})
    @DisplayName("[예외처리] 보너스 번호가 1~45가 아니면 예외가 발생한다.")
    void 보너스번호_검증_범위초과_예외처리(int bonusNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validator.validateBonusNumber(bonusNumber, WINNING_LOTTO_NUMBERS))
                .withMessageContaining(LottoException.LOTTO_NUMBER_OUT_OF_RANGE.getErrorMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("[예외처리] 보너스 번호가 당첨번호에 존재하면 예외가 발생한다.")
    void 보너스번호_검증_중복_예외처리(int bonusNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validator.validateBonusNumber(bonusNumber, WINNING_LOTTO_NUMBERS))
                .withMessageContaining(LottoException.BONUS_NUMBER_IN_WINNING_NUMBERS.getErrorMessage());
    }
}
