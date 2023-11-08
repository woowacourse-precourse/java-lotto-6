package lotto.domain;

import static lotto.error.ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE;
import static lotto.error.ErrorMessage.DUPLICATE_BONUS_NUMBER;
import static lotto.error.ErrorMessage.INVALID_BONUS_NUMBER_FORMAT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    private final WinningNumbers ANSWER = WinningNumbers.of("1,2,3,4,5,6");

    @DisplayName("보너스 숫자 생성 시 검증이 가능하다.")
    @Test
    void fromTest() {
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

    @DisplayName("특정 숫자가 주어지면 보너스 숫자와 동일한지 확인할 수 있다.")
    @Test
    void equalsTest() {
        BonusNumber bonusNumber = BonusNumber.from("7", ANSWER);
        assertAll(
                () -> assertThat(bonusNumber.equals(7)).isEqualTo(true),
                () -> assertThat(bonusNumber.equals(8)).isEqualTo(false)
        );
    }
}