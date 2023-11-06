package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersTest {

    @Test
    void draw() {
        List<Lotto> ticket = new ArrayList<>(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(2, 3, 4, 5, 6, 7)),
                new Lotto(List.of(2, 3, 4, 5, 6, 8)),
                new Lotto(List.of(3, 4, 5, 6, 7, 8)),
                new Lotto(List.of(4, 5, 6, 7, 8, 9)),
                new Lotto(List.of(5, 6, 7, 8, 9, 10)),
                new Lotto(List.of(6, 7, 8, 9, 10, 11))));

        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        Map<Grade, Integer> winners = winningNumbers.draw(ticket);

        for (Grade grade : winners.keySet()) {
            Integer count = winners.get(grade);
            System.out.println(grade + ": " + count);
        }
    }
}