package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("[Test - BonusNumber]")
public class BonusNumberTest {
    @Test
    @DisplayName("BonusNumber 생성 테스트 - 정상")
    void bonusNumberTest() {
        // Given
        String userInputBonusNumber = "3";

        // When
        BonusNumber bonusNumber = BonusNumber.create(userInputBonusNumber);

        // Then
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(Integer.parseInt(userInputBonusNumber));
    }

    @Test
    @DisplayName("BonusNumber 생성 테스트 - 로또 범위 밖의 숫자일 경우")
    void bonusNumberValidationTest() {
        // Given
        String userInputBonusNumber = "70";

        // When & Then
        assertThatThrownBy(() -> BonusNumber.create(userInputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
