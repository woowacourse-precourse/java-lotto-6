package lotto.domain;

import static lotto.domain.WinningLotto.BONUS_EXCEPTION_MSG;
import static lotto.domain.WinningLotto.NUMBERS_EXCEPTION_MSG;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
    @DisplayName("당첨 번호 입력시 정수가 아닌 것이 존재하면 예외가 발생한다.")
    @Test
    void inputNumbersNotInteger() {
        String numbersInput = ",2.4,5,-,,";
        String bonusInput = "1";
        assertThatThrownBy(() -> new WinningLotto(numbersInput, bonusInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBERS_EXCEPTION_MSG);
    }

    @DisplayName("보너스 번호 입력시 1이상 45이하의 정수가 아니면 예외가 발생한다.")
    @Test
    void inputBonusNotInteger() {
        String numbersInput = "1,2,3,4,5,6";
        List<String> bonusInputs = List.of("-1", "!?!", "46", ",");
        bonusInputs.stream().forEach(bonus -> {
            assertThatThrownBy(() -> new WinningLotto(numbersInput, bonus))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(BONUS_EXCEPTION_MSG);
        });
    }

    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void inputBonusDuplicatedNumber() {
        String numbersInput = "1,2,3,4,5,6";
        String bonusInput = "3";
        assertThatThrownBy(() -> new WinningLotto(numbersInput, bonusInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_EXCEPTION_MSG);
    }
}
