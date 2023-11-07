package lotto.io;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputManagerTest {

    InputManager inputManager = InputManager.getInstance();

    @Test
    void validateInputMoneyFormat() {
        String correctInput = "3000";
        String wrongInputOne = "12A3";

        inputManager.validateInputMoneyFormat(correctInput);

        Assertions.assertThatThrownBy(() -> inputManager.validateInputMoneyFormat(wrongInputOne))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateInputMoneyUnit() {
        int correctInput = 3000;
        int wrongInput = 1500;

        inputManager.validateInputMoneyUnit(correctInput);

        Assertions.assertThatThrownBy(() -> inputManager.validateInputMoneyUnit(wrongInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateWinningNumberSize() {
        String correctInput = "1,2,3,4,5,6";
        String wrongInput = "1,2,3,4,5";

        inputManager.validateWinningNumberSize(correctInput.split(","));

        Assertions.assertThatThrownBy(() -> inputManager.validateWinningNumberSize(wrongInput.split(",")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateWinningNumberFormat() {
        String correctInput = "1,2,3,4,5,6";
        String wrongInputOne = "1,2,3,4,5,!";

        inputManager.validateWinningNumberFormat(correctInput.split(","));

        Assertions.assertThatThrownBy(() -> inputManager.validateWinningNumberFormat(wrongInputOne.split(",")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateInputBonusNumberFormat() {
        String correctInput = "11";
        String wrongInputOne = "787";
        String wrongInputTwo = "!!";

        inputManager.validateInputBonusNumberFormat(correctInput);

        Assertions.assertThatThrownBy(() -> inputManager.validateInputBonusNumberFormat(wrongInputOne))
                .isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> inputManager.validateInputBonusNumberFormat(wrongInputTwo))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateInputNumberRange() {
        String correctInputOne = "1,2,3,4,5,6";
        String correctInputTwo = "11";
        String wrongInputOne = "1,2,3,4,5,78";
        String wrongInputTwo = "78";

        inputManager.validateInputNumberRange(correctInputOne.split(","));
        inputManager.validateInputNumberRange(correctInputTwo);

        Assertions.assertThatThrownBy(() -> inputManager.validateInputNumberRange(wrongInputOne.split(",")))
                .isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> inputManager.validateInputNumberRange(wrongInputTwo))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
