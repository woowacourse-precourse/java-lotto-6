package lotto.Model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketsAmountTest {
    @Test
    void testTicketsAmountWithValidInput() {
        // Arrange
        int validInput = 2000;

        // Act
        TicketsAmount ticketsAmount = new TicketsAmount(validInput);

        // Assert
        assertThat(ticketsAmount.getTicketsPrice()).isEqualTo(validInput);
        assertThat(ticketsAmount.getTickets()).isEqualTo(validInput / 1000);
    }
    @DisplayName("1000미만의 금액을 입력하면 예외가 발생한다.")
    @Test
    void testTicketsAmountWithInvalidMinimumInput() {
        // Arrange
        int invalidInput = 20;

        // Act & Assert
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new TicketsAmount(invalidInput))
                .withMessageContaining("[ERROR]");
    }
    @DisplayName("1000원 단위가 아닌 금액을 입력하면 예외가 발생한다.")
    @Test
    void testTicketsAmountWithInvalidUnitInput() {
        // Arrange
        int invalidInput = 1200;

        // Act & Assert
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new TicketsAmount(invalidInput))
                .withMessageContaining("[ERROR]");
    }

}