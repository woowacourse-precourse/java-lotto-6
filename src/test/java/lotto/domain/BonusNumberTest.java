package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    private static final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    @Test
    @DisplayName("정상적인 보너스 번호를 입력")
    void inputCorrectBonusNumberTest() {
        // Given
        String inputBonusNumber = "7";

        // When
        BonusNumber bonusNumber = new BonusNumber(inputBonusNumber, lotto);

        // Then
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(7);
    }

    @Test
    @DisplayName("숫자가 아닌 보너스 번호 입력이 들어오면 예외가 발생")
    void inputNotNumberTest() {
        // Given
        String inputBonusNumber = "one";

        // When & Then
        assertThatThrownBy(() -> new BonusNumber(inputBonusNumber, lotto))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("범위를 벗어난 보너스 번호 입력이 들어오면 예외가 발생")
    void inputOutOfRangeBonusNumberTest() {
        // Given
        String inputBonusNumber = "47";

        // When & Then
        assertThatThrownBy(() -> new BonusNumber(inputBonusNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("2개 이상의 보너스 번호 입력이 들어오면 예외가 발생")
    void inputOverOneBonusNumberTest() {
        // Given
        String inputBonusNumber = "4,6";

        // When & Then
        assertThatThrownBy(() -> new BonusNumber(inputBonusNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호에 이미 포함 되어 있는 숫자가 입력될 경우 예외 발생")
    void inputAlreadyInLottoTest() {
        // Given
        String inputBonusNumber = "3";

        // When & Then
        assertThatThrownBy(() -> new BonusNumber(inputBonusNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
