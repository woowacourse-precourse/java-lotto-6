package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserInputTest {
    private UserInput userInput;

    @BeforeEach
    void setUp() {
        userInput = new UserInput();
    }

    @Test
    void 구입_금액_글자_입력() {
        assertThatThrownBy(() -> userInput.validateMoney("글자"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액_300원_단위_입력() {
        assertThatThrownBy(() -> userInput.validateMoney("900"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액_음수_입력() {
        assertThatThrownBy(() -> userInput.validateMoney("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_글자_입력() {
        assertThatThrownBy(() -> userInput.validateNumber("글자"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_100_입력() {
        assertThatThrownBy(() -> userInput.validateMoney("100"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}