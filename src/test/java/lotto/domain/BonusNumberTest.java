package lotto.domain;

import static lotto.validator.ErrorMessage.DUPLICATED_BONUS_NUMBER;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BonusNumberTest {

    @DisplayName("보너스 번호가 당첨 번호와 겹치면 예외 발생")
    @Test
    void createBonusNumber() {
        Assertions.assertThatThrownBy(() -> new BonusNumber(List.of(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_BONUS_NUMBER.message());

    }

    @DisplayName("보너스 번호와 일치하는 지 테스트")
    @ParameterizedTest
    @CsvSource({"7,true", "8,false"})
    void isBonusNumber(int bonus, boolean expected) {
        BonusNumber bonusNumber = new BonusNumber(List.of(1, 2, 3, 4, 5, 6), 7);

        org.assertj.core.api.Assertions.assertThat(bonusNumber.isBonusNumber(bonus)).isEqualTo(expected);
    }
}
