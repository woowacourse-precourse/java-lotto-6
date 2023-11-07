package lotto.ControllerTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import lotto.Controller.InputController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputControllerTest {

    @DisplayName("티켓 금액에 정수가 아닌 값이 포함되면 예외가 발생한다.")
    @Test
    public void inputWrongTypeOfTicketAmount() {
        //Arrange
        String input = "1000won";
        //Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputController.toWinningNumbers(input));
        // Assert
        assertTrue(exception.getMessage().contains("[ERROR]"));

    }

    @DisplayName("당첨 번호에 정수가 아닌 값이 포함되면 예외가 발생한다.")
    @Test
    public void inputWrongTypeOfWinningNumbers() {
        //Arrange
        String input = "10u";
        //Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputController.toWinningNumbers(input));
        // Assert
        assertTrue(exception.getMessage().contains("[ERROR]"));

    }

    @DisplayName("보너스 번호에 정수가 아닌 값이 포함되면 예외가 발생한다.")
    @Test
    public void inputWrongTypeOfBonusNumber() {
        //Arrange
        String input = "39번";
        //Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputController.toWinningNumbers(input));
        // Assert
        assertTrue(exception.getMessage().contains("[ERROR]"));

    }


}
