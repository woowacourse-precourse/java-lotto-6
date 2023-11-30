package validator;

import domain.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.constants.Constants;
import view.validator.BonusValidator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static util.message.ExceptionMessage.*;

public class BonusValidatorTest {

    @ParameterizedTest
    @DisplayName("보너스번호를 ")
    @ValueSource(strings = {"4565", "1223"})
    void givenNonRangeBonus_thenFail(final int purchaseAmount) {
        assertThatThrownBy(() -> PurchaseAmount.create(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(UNIT_MESSAGE.getValue(), Constants.ONE_THOUSAND.getValue()));
    }

    @ParameterizedTest
    @DisplayName("보너스번호를 빈값으로 입력한 경우 예외가 발생한다.")
    @ValueSource(strings = {"", " ", "  ", "    ", "     ", "\n", "\t", "\r"})
    void givenBlankAmount_thenFail(final String bonus) {
        assertThatThrownBy(() -> BonusValidator.validate(bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(BLANK_MESSAGE.getValue()));
    }

    @ParameterizedTest
    @DisplayName("보너스번호를 숫자가 아닌 형태로 입력한 경우 예외가 발생한다.")
    @ValueSource(strings = {"abc", "12bd"})
    void givenNonNumeric_thenFail(final String bonus) {
        assertThatThrownBy(() -> BonusValidator.validate(bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(TYPE_MESSAGE.getValue()));
    }

    @ParameterizedTest
    @DisplayName("보너스번호를 범위에 벗어나면 예외가 발생한다.")
    @ValueSource(strings = {"-1", "49"})
    void givenLessZero_thenFail(final String purchaseAmount) {
        assertThatThrownBy(() -> BonusValidator.validate(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(RANGE_START_BETWEEND_END.getValue(), 1, 45));
    }
}
