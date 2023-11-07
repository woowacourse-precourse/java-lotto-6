package lotto;

import lotto.Model.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultTest {
    private List<Lotto> lottoTickets;
    private List<Integer> winningNumbers;

    @BeforeEach
    public void setUp() {
        // Initialize lottoTickets with Lotto instances
        lottoTickets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
            Collections.shuffle(numbers);
            lottoTickets.add(new Lotto(numbers));
        }

        // Initialize winningNumbers and bonusNumber
        winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void testCalculateMatchingCount() {
        int bonusNumber = 7;

        // Test a ticket that matches all numbers and the bonus number
        Lotto allMatchingTicket = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int matchingCount = Result.calculateMatchingCount(allMatchingTicket, winningNumbers, bonusNumber);
        assertEquals(6, matchingCount);

        // Test a ticket that matches all numbers without the bonus number
        Lotto noBonusMatchingTicket = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        matchingCount = Result.calculateMatchingCount(noBonusMatchingTicket, winningNumbers, bonusNumber);
        assertEquals(6, matchingCount);

        // Test a ticket that matches only 3 numbers
        Lotto threeMatchingTicket = new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12));
        matchingCount = Result.calculateMatchingCount(threeMatchingTicket, winningNumbers, bonusNumber);
        assertEquals(3, matchingCount);
    }

    @Test
    public void testCalculateResults() {
        int bonusNumber = 7;
        Map<String, Integer> results = Result.calculateResults(lottoTickets, winningNumbers, bonusNumber);

        // Ensure the results are correctly calculated
        assertEquals(0, results.get("0"));
        assertEquals(0, results.get("1"));
        assertEquals(0, results.get("2"));
        assertEquals(0, results.get("3"));
        assertEquals(0, results.get("4"));
        assertEquals(0, results.get("5"));
        assertEquals(0, results.get("5.1"));
        assertEquals(10, results.get("6"));
    }

}

