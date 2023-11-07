package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyValidatorTest extends NsTest {
    private final MoneyValidator moneyValidator = MoneyValidator.getInstance();

    @DisplayName("문자열 입력이 공백이다.")
    @Test
    void validateStringFormat() {
        assertThatThrownBy(() -> moneyValidator.validateBlankInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력은 공백이어선 안됩니다. 다시 입력하세요.");
    }

    @DisplayName("금액이 숫자가 아니다.")
    @Test
    void validateNumberFormat() {
        assertThatThrownBy(() -> moneyValidator.validateNumberFormat("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력은 숫자이어야 합니다. 다시 입력하세요.");
    }

    @DisplayName("금액이 음수다.")
    @Test
    void validateNumberFormat2() {
        assertThatThrownBy(() -> moneyValidator.validateNumberFormat("-2000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력은 숫자이어야 합니다. 다시 입력하세요.");
    }

    @DisplayName("금액이 0원이다.")
    @Test
    void validateZeroMoney() {
        moneyValidator.validateMoneyInput("0");

        assertThat(output()).contains("[ERROR] 구입금액은 0원일 수 없습니다. 다시 입력하세요.");
    }

    @DisplayName("금액이 1000원 단위가 아니다.")
    @Test
    void validateNotThousandUnit() {
        moneyValidator.validateMoneyInput("3001");

        assertThat(output()).contains("[ERROR] 구입금액은 1000원 단위입니다. 다시 입력하세요.");
    }

    @Override
    protected void runMain() {
    }
}