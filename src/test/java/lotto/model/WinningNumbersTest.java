package lotto.model;

import lotto.model.winning.WinningNumbers;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("당첨 번호 및 보너스 번호 테스트")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WinningNumbersTest {
    @Test
    @Order(1)
    @DisplayName("당첨 번호가 없는 경우 예외가 발생한다.")
    void createWinningNumbersByEmpty() {
        assertThatThrownBy(() -> new WinningNumbers(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @Order(2)
    @DisplayName("당첨 번호 입력이 숫자나 쉼표가 아니면 예외가 발생한다.")
    void createWinningNumbersByInvalidInput() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,6a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @Order(3)
    @DisplayName("당첨 번호 입력이 6개가 아니면 예외가 발생한다.")
    void createWinningNumbersByInvalidSize() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @Order(4)
    @DisplayName("당첨 번호 입력이 1보다 작으면 예외가 발생한다.")
    void createWinningNumbersByInvalidRangeLower() {
        assertThatThrownBy(() -> new WinningNumbers("-1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @Order(5)
    @DisplayName("당첨 번호 입력이 45보다 크면 예외가 발생한다.")
    void createWinningNumbersByInvalidRangeUpper() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @Order(6)
    @DisplayName("당첨 번호가 중복되면 예외가 발생한다.")
    void createWinningNumbersByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @Order(7)
    @DisplayName("보너스 번호가 1개가 아니면 예외가 발생한다.")
    void createWinningNumbersByInvalidBonusNumberSize() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,6")
                .addBonusNumber("1,2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @Order(8)
    @DisplayName("보너스 번호가 1보다 작으면 예외가 발생한다.")
    void createWinningNumbersByInvalidBonusNumberRangeLower() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,6")
                .addBonusNumber("-2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @Order(9)
    @DisplayName("보너스 번호가 45보다 크면 예외가 발생한다.")
    void createWinningNumbersByInvalidBonusNumberRangeUpper() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,6")
                .addBonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @Order(10)
    @DisplayName("보너스 번호 입력이 숫자가 아니면 예외가 발생한다.")
    void createWinningNumbersByInvalidBonusNumber() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,6")
                .addBonusNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @Order(11)
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    void createWinningNumbersByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,6")
                .addBonusNumber("6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}