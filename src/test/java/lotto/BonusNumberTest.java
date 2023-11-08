package lotto;

import java.util.List;
import lotto.constants.ErrorMessage;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("보너스 번호 검증 테스트")
public class BonusNumberTest {

    @DisplayName("입력 값 검증")
    @Nested
    class ValidatorTest {
        private Lotto winningNumbers;

        @BeforeEach
        void init() {
            winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        }

        @DisplayName("숫자가 아닌 값 입력 시 예외가 발생한다.")
        @Test
        void inputNotDigit() {
            //given
            String bonusNumber = "aaa";
            //when, then
            Assertions.assertThatThrownBy(() -> new BonusNumber(bonusNumber, winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.BONUS_NUMBER_NOT_DIGIT.getMessage());
        }

        @DisplayName("1~45 이외의 값 입력 시 예외가 발생한다.")
        @ParameterizedTest(name = "보너스 번호=\"{0}\"")
        @ValueSource(strings = {"0", "46"})
        void inputNotInRange(String bonusNumber) {
            Assertions.assertThatThrownBy(() -> new BonusNumber(bonusNumber, winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.LOTTO_NUMBER_NOT_IN_RANGE.getMessage());
        }

        @DisplayName("당첨 번호와 중복된 숫자 입력 시 예외가 발생한다.")
        @Test
        void inputNotUnique() {
            String bonusNumber = "1";
            Assertions.assertThatThrownBy(() -> new BonusNumber(bonusNumber, winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.LOTTO_NUMBER_NOT_UNIQUE.getMessage());
        }
    }
}
