package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StartLottoTest {
    private static StartLotto test;

    @DisplayName("테스트할 StartLotto 객체 먼저 생성")
    @BeforeEach
    void init() {
        test = new StartLotto();
    }

    @DisplayName("구입 금액이 숫자 형식이 아니라면 예외가 발생한다.")
    @Test
    void checkPurchasePriceNotNumberFormat() {
        assertThatThrownBy(() -> {
            String input = "10dkfk";
            test.checkPurchasePrice(input);
        }).isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("올바른 숫자 형식이 아닙니다. 숫자를 입력해주세요.");
    }

    @DisplayName("구입 금액이 1000원 단위가 아니라면 예외가 발생한다.")
    @Test
    void checkPurchasePriceNot1000wonUnit() {
        assertThatThrownBy(() -> {
            String input = "101";
            test.checkPurchasePrice(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입금액은 1000원 단위입니다. 다시 입력해주세요.");
    }

    @DisplayName("당첨 번호는 쉼표로 구분된다.")
    @Test
    void checkWinningNumberSplit() {
        assertThatCode(() -> {
            String input = "1,2, 3,  4, 5,6";
            test.checkWinningNumbers(input);
        }).doesNotThrowAnyException();
    }

    @DisplayName("보너스 번호가 숫자가 아니라면 예외가 발생한다.")
    @Test
    void checkBonusNumberNotNumberFormat() {
        assertThatThrownBy(() -> {
            String input = "ten";
            test.checkBonusNumber(input);
        }).isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("올바른 숫자 형식이 아닙니다. 숫자를 입력해주세요.");
    }

    @DisplayName("보너스 번호가 1 ~ 45 사이의 숫자가 아니라면 예외가 발생한다.")
    @Test
    void checkBonusNumberOutOfRange() {
        assertThatThrownBy(() -> {
            String input = "-20";
            test.checkBonusNumber(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 1 ~ 45 사이의 값을 가집니다.");
    }

    @DisplayName("보너스 번호와 당첨 번호 사이에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void checkBonusNumberIsDuplicatedNumber() {
        assertThatThrownBy(() -> {
            String winningNumbers = "1,2,3,4,5,6";
            String input = "3";
            test.checkWinningNumbers(winningNumbers);
            test.checkBonusNumber(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호와 당첨 번호에는 서로 중복되는 숫자가 없습니다. 다시 입력해주세요.");
    }
}
