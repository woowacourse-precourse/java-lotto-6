package lotto.domain;

import static lotto.error.ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE;
import static lotto.error.ErrorMessage.DUPLICATE_BONUS_NUMBER;
import static lotto.error.ErrorMessage.INVALID_BONUS_NUMBER_FORMAT;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    private final WinningNumbers ANSWER = WinningNumbers.of("1,2,3,4,5,6");

    @DisplayName("보너스 숫자 검증이 가능하다.")
    @Test
    void validateBonusNumberTest() {
        assertAll(
                () -> assertThatThrownBy(() -> BonusNumber.from("love", ANSWER))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(INVALID_BONUS_NUMBER_FORMAT),
                () -> assertThatThrownBy(() -> BonusNumber.from("46", ANSWER))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(BONUS_NUMBER_OUT_OF_RANGE),
                () -> assertThatThrownBy(() -> BonusNumber.from("6", ANSWER))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(DUPLICATE_BONUS_NUMBER),
                () -> assertThatCode(() -> BonusNumber.from("7", ANSWER))
                        .doesNotThrowAnyException()
        );
    }
}