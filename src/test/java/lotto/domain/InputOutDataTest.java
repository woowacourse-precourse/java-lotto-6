package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputOutDataTest {
    InputManager inputManager = new InputManager();
    InputDataAdapter inputDataAdapter = new InputDataAdapter();

    @DisplayName("당첨 번호 입력값에 숫자가 아닐 경우 예외 발생")
    @Test
    void inputLottoDrawNumberContainNotNumber() {
        String input = "1,2,ab,4,5,6s";

        assertThatThrownBy(() -> inputDataAdapter.transformLottoDrawNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력값에 숫자가 아닐 경우 예외 발생")
    @Test
    void inputLottoDrawBonusNumberContainNotNumber() {
        String input = "one";

        assertThatThrownBy(() -> inputDataAdapter.transformLottoDrawBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
