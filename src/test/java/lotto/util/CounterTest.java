package lotto.util;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.parser.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CounterTest {
    @DisplayName("맞힌 등수별 갯수를 센다.")
    @Test
    void countRank() {
        int number = Parser.parsePurchaseAmount("8000");
        List<Lotto> tickets = Generator.publishTickets(number);
        Lotto numbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 44;
        List<Result> results = Matcher.matchResult(tickets, numbers, bonus);
        for (Lotto lotto : tickets) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println("-------------결과---------------");
        System.out.println(results);
        System.out.println("--------------------------------");
        System.out.println(Counter.countRank(results));
    }
}
