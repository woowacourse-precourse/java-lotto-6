package lotto.domain.answer.number;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoAnswerValidatorTest {

    @Test
    @DisplayName("당첨번호 범위 내인 경우 정상처리를 합니다.")
    void 당첨번호_범위_정상경우() {
        // GIVEN
        List<Integer> answer = List.of(1, 2, 3, 4, 5, 6);
        // THEN
        assertDoesNotThrow(() -> {
            // WHEN
            LottoAnswerValidator.validNumberRange.accept(answer);
        });
    }

    @Test
    @DisplayName("당첨번호 범위를 벗어난 경우 예외처리를 합니다.")
    void 당첨번호_범위_벗어난경우() {
        // GIVEN
        List<Integer> answer = List.of(46, 47, 48, 49, 50, 51);
        // THEN
        assertThrows(IllegalArgumentException.class, () -> {
            // WHEN
            LottoAnswerValidator.validNumberRange.accept(answer);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    @DisplayName("당첨번호의 길이가 6이라면 정상처리를 합니다.")
    void 당첨번호_길이_6인경우(String lottoAnswerInput) {
        LottoAnswerValidator.validSize.accept(lottoAnswerInput);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1"})
    @DisplayName("당첨번호의 길이가 6이 아니라면 예외처리를 합니다.")
    void 당첨번호_길이_6이_아닌경우(String lottoAnswerInput) {
        // THEN
        assertThrows(IllegalArgumentException.class, () -> {
            // WHEN
            LottoAnswerValidator.validSize.accept(lottoAnswerInput);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "45"})
    @DisplayName("보너스 번호 범위 내인 경우 정상처리를 합니다.")
    void 보너스번호_범위_정상인경우(String bonusInput) {
        assertDoesNotThrow(() -> LottoAnswerValidator.validateBonusInput.accept(bonusInput));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    @DisplayName("보너스 번호 범위를 벗어난 경우 예외처리를 합니다.")
    void 보너스번호_범위_벗어난경우(String bonusInput) {
        assertThrows(IllegalArgumentException.class, () -> LottoAnswerValidator.validateBonusInput.accept(bonusInput));
    }
}