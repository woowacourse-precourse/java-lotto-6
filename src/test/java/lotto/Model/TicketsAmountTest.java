package lotto.Model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketsAmountTest {
    @DisplayName("2000원을 입력하면 로또는2장, 금액은 2000원이 저장된다.")
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
}
