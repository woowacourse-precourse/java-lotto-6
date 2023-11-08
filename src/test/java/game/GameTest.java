package game;

import lotto.Lotto;
import lotto.ProfitCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    List<Integer> numbers = new ArrayList<>();

    @BeforeEach
    void set() {
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
    }

    @DisplayName("일치하는 숫자 개수")
    @Test
    void winningStatistics() {
        Lotto lotto = new Lotto(numbers);
        List<List<Integer>> ticketNumbers = new ArrayList<>();
        List<Integer> ticket = new ArrayList<>();
        ticket.add(1);
        ticket.add(2);
        ticket.add(3);
        ticket.add(4);
        ticket.add(5);
        ticket.add(6);
        ticketNumbers.add(ticket);

        Map<Integer, Integer> test = new HashMap<>();
        test.put(2, 0);
        test.put(3, 0);
        test.put(4, 0);
        test.put(5, 0);
        test.put(6, 1);
        assertEquals(lotto.winningStatistics(ticketNumbers, 7), test);
    }

    @DisplayName("수익률 계산")
    @Test
    void calculateProfitRate() {
        ProfitCalculator profitCalculator = new ProfitCalculator();
        Map<Integer, Integer> winningStatistics = new HashMap<>();
        winningStatistics.put(2, 0);
        winningStatistics.put(3, 2);
        winningStatistics.put(4, 0);
        winningStatistics.put(5, 0);
        winningStatistics.put(6, 0);

        String buying = "5000";

        Double test = 200.0;

        assertEquals(profitCalculator.calculateProfitRate(winningStatistics, buying), test);
    }
}
