package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static org.junit.jupiter.api.Assertions.*;

class BuyTicketsTest {
    @BeforeAll
    static void InitTest() {
        SystemIO systemIO = new SystemIO();
    }

    @Test
    @DisplayName("입력값은 숫자여야 한다.")
    void ValidateInputIsIntegerTest() {
        String purchaseAmount = "String INPUT";
        Assertions.assertThrows(IllegalStateException.class, () -> new BuyTickets(purchaseAmount));
    }

    @Test
    @DisplayName("입력값은 숫자여야 한다.")
    void ValidateInputIsMultipleNumberOfThousand() {
        String purchaseAmount = "1200";
        Assertions.assertThrows(IllegalStateException.class, () -> new BuyTickets(purchaseAmount));
    }
}