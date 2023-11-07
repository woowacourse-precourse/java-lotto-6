package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.Lotto;
import lotto.validator.BonusNumValidator;
import lotto.validator.PaymentValidator;
import lotto.validator.WinningNumValidator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 정수가 아니면 예외가 발생한다.")
    @Test
    void createBonusNumberByCharacter() {
        assertThatThrownBy(() -> BonusNumValidator.validate("보너스 번호"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1에서 45사이의 수가 아니면 예외가 발생한다.")
    @Test
    void createBonusNumberOverRange() {
        assertThatThrownBy(() -> BonusNumValidator.validate("51"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("부족한 가격이 입력되면 예외가 발생한다.")
    @Test
    void buyLottoAtNotEnoughPrice() {
        assertThatThrownBy(() -> PaymentValidator.validate("500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("거스름돈이 발생하면 예외가 발생한다.")
    @Test
    void existChange() {
        assertThatThrownBy(() -> PaymentValidator.validate("2500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 정수가 아닌 값이 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByCharacter() {
        final String[] winningNum = { "1", "2", "3", "a", "5", "6" };
        assertThatThrownBy(() -> WinningNumValidator.validate(winningNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningNumberByOverSize() {
        final String[] winningNum = { "1", "2", "3", "4", "5", "6", "7" };
        assertThatThrownBy(() -> WinningNumValidator.validate(winningNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByDuplicatedNumber() {
        final String[] winningNum = { "1", "2", "3", "4", "5", "5" };
        assertThatThrownBy(() -> WinningNumValidator.validate(winningNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1에서 45사이의 수가 아니면 예외가 발생한다.")
    @Test
    void reateWinningNumberByDuplicatedNumber() {
        final String[] winningNum = { "1", "2", "3", "4", "5", "52" };
        assertThatThrownBy(() -> WinningNumValidator.validate(winningNum))
                .isInstanceOf(IllegalArgumentException.class);
    }
}