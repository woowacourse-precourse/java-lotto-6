package lotto.domain;

import java.util.List;
import lotto.constant.ExceptionMessage;
import lotto.util.NumberConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class BonusNumberTest {
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
        bonusNumber.validateNumber("7");
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(7);
    }


    @DisplayName("보너스 번호가 범위를 벗어났을 때 예외 발생")
    @Test
    void validateNumberOutOfRange() {
        assertThatThrownBy(() -> bonusNumber.validateNumber("46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_CORRECT_RANGE.getMessage());
    }


    @DisplayName("보너스 번호가 로또번호와 중복될 때 예외 발생")
    @Test
    void validateNumberIsDuplicate() {
        assertThatThrownBy(() -> bonusNumber.validateNumber("1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.DUPLICATE_NUMBERS_LOTTO.getMessage());
    }


}

