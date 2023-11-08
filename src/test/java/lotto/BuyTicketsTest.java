package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static org.assertj.core.api.Assertions.assertThat;

class BuyTicketsTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void InitTest() {
        SystemIO systemIO = new SystemIO();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("입력값은 숫자여야 한다.")
    void validateInputIsIntegerTest() {
        String purchaseAmount = "String INPUT";
        InputStream byteOfPurchaseAmount = new ByteArrayInputStream(purchaseAmount.getBytes());
        System.setIn(byteOfPurchaseAmount);
        Assertions.assertThrows(NoSuchElementException.class, () -> new BuyTickets());
    }

    @Test
    @DisplayName("입력값은 1000의 배수여야 한다.")
    void validateInputIsMultipleNumberOfThousand() {
        String purchaseAmount = "1200";
        InputStream byteOfPurchaseAmount = new ByteArrayInputStream(purchaseAmount.getBytes());
        System.setIn(byteOfPurchaseAmount);
        Assertions.assertThrows(NoSuchElementException.class, () -> new BuyTickets());
    }

    @Test
    @DisplayName("입력한 만큼의 티켓이 구입되었는지 확인")
    void testNumberOfTickets() throws IOException {
        int ticketAmount = pickNumberInRange(1, 99);
        String buyAmounts = String.valueOf(ticketAmount * 1000);
        InputStream byteOfPurchaseAmount = new ByteArrayInputStream(buyAmounts.getBytes());
        System.setIn(byteOfPurchaseAmount);
        BuyTickets buyTickets = new BuyTickets();
        assertThat(buyTickets.getLotteryNumbers().size()).isEqualTo(ticketAmount);


    }
}