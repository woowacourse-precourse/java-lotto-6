package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.Constants;
import lotto.domain.Lotto;

class WinningLottoValidatorTest {

    private final Lotto winningLotto = new Lotto(List.of(2, 3, 4, 5, 6, 7));

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(ints = {0, 46})
    @DisplayName("당첨 번호 예외 처리: 보너스 번호가 범위를 벗어난 경우")
    void givenLottoAndBonusNumber_whenValidateBonusNumberRange_thenThrowException(int bonusNumber) {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLottoValidator.validate(bonusNumber, winningLotto))
                .withMessageStartingWith(Constants.ERROR_MESSAGE)
                .withMessageContaining("로또 번호는 1 ~ 45 숫자만 가능합니다.");
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(ints = {2, 3, 4, 5, 6, 7})
    @DisplayName("당첨 번호 예외 처리: 당첨 번호 중 하나와 중복된 경우")
    void givenLottoAndBonusNumber_whenValidateDuplication_thenThrowDuplicationException(int bonusNumber) {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLottoValidator.validate(bonusNumber, winningLotto))
                .withMessageStartingWith(Constants.ERROR_MESSAGE)
                .withMessageContaining("당첨 번호에 이미 존재하는 숫자입니다.");
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(ints = {1, 45})
    @DisplayName("당첨 번호 예외 처리 통과")
    void givenLottoAndBonusNumber_whenValidate_thenNoException(int bonusNumber) {
        // when & then
        assertThatNoException()
                .isThrownBy(() -> WinningLottoValidator.validate(bonusNumber, winningLotto));
    }

}
