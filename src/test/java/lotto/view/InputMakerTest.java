package lotto.view;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;


class InputMakerTest {
    static InputMaker inputMaker;

    @BeforeEach
    void setup() {
        inputMaker = new InputMaker();
    }

    @DisplayName("문자열을 숫자로 바꾸는 기능 + 숫자가 아닌경우 예외처리")
    @Test
    void inputNum_TEST() {
        assertThat(inputMaker.inputNum("123"))
                .isEqualTo(123);
        assertThatThrownBy(()->inputMaker.inputNum("q"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(",로 입력을 구분하여 숫자로 받는 기능")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void inputWinnerNumber(String message) {
        assertThat(inputMaker.inputWinningNumber(message))
                .contains(1,2,3,4,5,6);
    }
}