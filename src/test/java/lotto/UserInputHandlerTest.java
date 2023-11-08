package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class UserInputHandlerTest {

    private UserInputHandler userInputHandler;
    private final String nonNumericPattern = ".*[^0-9].*";
    private final String duplicateNumber = "1,1,2,2,3,3";


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

    @Test
    @DisplayName("숫자가 아닌 경우 테스트")
    void lottoPurchaseStringTest() {
        assertThatThrownBy(() -> userInputHandler.validUserLottoPurchase(nonNumericPattern))
                .isInstanceOf(NumberFormatException.class);

        assertThatThrownBy(() -> userInputHandler.validateUserWinningNumbers(nonNumericPattern))
                .isInstanceOf(NumberFormatException.class);

        assertThatThrownBy(() -> userInputHandler.validateNumbers(nonNumericPattern))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("1-45 범위 초과 테스트")
    void validateWinningNumberTest() {
        String isInRange = "([1-9]|[1-3][0-9]|4[0-5])";
        String[] newIsInRange = isInRange.split("");
        assertThatThrownBy(() -> userInputHandler.validateLength(newIsInRange))
                .isInstanceOf(IllegalArgumentException.class);

        int number = 0;
        assertThatThrownBy(() -> userInputHandler.isOverLengthNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복 입력 테스트")
    void validateWinningNumbersTest() {
        assertThatThrownBy(() -> userInputHandler.validDuplicateNumbers(new String[]{duplicateNumber}))
                .isInstanceOf(IllegalArgumentException.class);
    }

}