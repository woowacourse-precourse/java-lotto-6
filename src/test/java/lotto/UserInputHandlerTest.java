package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class UserInputHandlerTest {

    private UserInputHandler userInputHandler;

    @BeforeEach
    void setUp() {
        userInputHandler = new UserInputHandler();
    }

//    @Test
    @DisplayName("로또 구매금액 1000원 미만 테스트")
    @ValueSource(strings = {"-200, -250, -2000, 0, 100, 999"})
    @ParameterizedTest
    void lottoPurchaseTest(String input) {
        assertThatThrownBy(() -> userInputHandler.validUserLottoPurchase(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매금액 1000원 단위 테스트")
    @ValueSource(strings = {"150, 1500, 15, 1.5, 15000"})
    @ParameterizedTest
    void lottoPurchaseDivision1000Test(String input) {
        assertThatThrownBy(() -> userInputHandler.validUserLottoPurchase(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매금액 문자열 테스트")
    @ValueSource(strings = {"*, 1-2, , --1, 1--, --1--"})
    @ParameterizedTest
    void lottoPurchaseStringTest(String input) {
        assertThatThrownBy(() -> userInputHandler.validUserLottoPurchase(input))
                .isInstanceOf(NumberFormatException.class);
    }
}