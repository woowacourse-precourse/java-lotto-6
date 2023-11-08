package lotto;

import static lotto.enums.ExceptionCase.INPUT_TYPE_MISMATCH;
import static lotto.enums.ExceptionCase.NUMBER_DUPLICATION;
import static lotto.enums.ExceptionCase.NUMBER_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import lotto.validator.PrizeValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeTest {
    private static final Lotto VALID_LOTTO = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("당첨 숫자의 입력 형식이 올바르지 않으면 예외가 발생한다.")
    @Test
    void createUserByNegativeNumber() {
        assertThatThrownBy(() -> PrizeValidator.validateNumbers("asd"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_TYPE_MISMATCH.message());
    }

    @DisplayName("보너스 번호가 양의 정수가 아니면 예외가 발생한다")
    @Test
    void createBonusNumberNegativeInt() {
        assertThatThrownBy(() -> PrizeValidator.validateBonusNumber("-50", VALID_LOTTO))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_TYPE_MISMATCH.message());
    }

    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다")
    @Test
    void createBonusNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> PrizeValidator.validateBonusNumber("1", VALID_LOTTO))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBER_DUPLICATION.message());
    }

    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다")
    @Test
    void createBonusNumberByOverRange() {
        assertThatThrownBy(() -> PrizeValidator.validateBonusNumber("46", VALID_LOTTO))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBER_OUT_OF_RANGE.message());
    }
}
