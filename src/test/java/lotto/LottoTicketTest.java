package lotto;

import lotto.Model.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoTicketTest {
    private LottoTicket lottoTicket;

    @BeforeEach
    public void setUp() {
        lottoTicket = new LottoTicket();
    }

    @Test
    public void testGenerateSingleLottoTicket() {
        Lotto lotto = LottoTicket.generateSingleLottoTicket();
        List<Integer> numbers = lotto.getNumbers();

        // Test if the Lotto has exactly 6 unique numbers
        assertEquals(6, numbers.size());
        Set<Integer> uniqueNumbers = Set.copyOf(numbers);
        assertEquals(6, uniqueNumbers.size());

        // Test if the numbers are within the valid range (1 to 45)
        for (int number : numbers) {
            assertTrue(number >= 1 && number <= 45);
        }
    }

    @Test
    public void testGenerateLottoTickets() {
        int purchaseAmount = 5000;
        List<Lotto> lottoTickets = LottoTicket.generateLottoTickets(purchaseAmount);

        // Test if the number of Lotto tickets generated matches the purchase amount
        assertEquals(purchaseAmount / 1000, lottoTickets.size());

        // Test each Lotto ticket generated
        for (Lotto lotto : lottoTickets) {
            List<Integer> numbers = lotto.getNumbers();

            // Test if the Lotto has exactly 6 unique numbers
            assertEquals(6, numbers.size());
            Set<Integer> uniqueNumbers = Set.copyOf(numbers);
            assertEquals(6, uniqueNumbers.size());

            // Test if the numbers are within the valid range (1 to 45)
            for (int number : numbers) {
                assertTrue(number >= 1 && number <= 45);
            }
        }
    }
}

