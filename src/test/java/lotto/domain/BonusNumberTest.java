package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.constant.ExceptionMessage;
import lotto.util.NumberConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    private static final String WITHIN_RANGE_BONUS = "7";
    private static final String OUT_OF_RANGE_BONUS = "46";
    private static final String DUPLICATE_BONUS = "1";
    private static final String NON_NUMERIC_BONUS = "a";
    private static final String OUT_OF_INT_RANGE_BONUS = "3000000000";
    private static final String INTERNAL_SPACES_NUMBER = "1 2";
    private static final int EXPECTED_BONUS_NUMBER = 7;

    private Lotto lotto;
    private NumberConverter numberConverter;
    private BonusNumber bonusNumber;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        numberConverter = new NumberConverter();
        bonusNumber = new BonusNumber(lotto, numberConverter);
    }

    @DisplayName("보너스 번호가 올바른 범위 내에 있는지 검증")
    @Test
    void validateNumberWithinRange() {
        bonusNumber.validateNumber(WITHIN_RANGE_BONUS);
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(EXPECTED_BONUS_NUMBER);
    }


    @DisplayName("보너스 번호가 범위를 벗어났을 때 예외 발생")
    @Test
    void validateNumberOutOfRange() {
        assertThatThrownBy(() -> bonusNumber.validateNumber(OUT_OF_RANGE_BONUS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_CORRECT_RANGE.getMessage());
    }


    @DisplayName("보너스 번호가 로또번호와 중복될 때 예외 발생")
    @Test
    void validateNumberIsDuplicate() {
        assertThatThrownBy(() -> bonusNumber.validateNumber(DUPLICATE_BONUS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.DUPLICATE_NUMBERS_LOTTO.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 문자일 때 예외 발생")
    void validateNumberIsNotNumeric() {
        assertThatThrownBy(() -> bonusNumber.validateNumber(NON_NUMERIC_BONUS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_NUMBER.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 int의 범위를 벗어났을 때 예외 발생")
    void validateNumberIsOutOfInt() {
        assertThatThrownBy(() -> bonusNumber.validateNumber(OUT_OF_INT_RANGE_BONUS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_AMOUNT_MESSAGE.getMessage());
    }

    @Test
    @DisplayName("보너스 번호 숫자 사이에 공백이 있을 때 예외 발생")
    void validateNoBlank() {
        assertThatThrownBy(() -> bonusNumber.validateNumber(INTERNAL_SPACES_NUMBER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.PLEASE_NOT_INPUT_BETWEEN_NUMBER_BLANK.getMessage());
    }

}


