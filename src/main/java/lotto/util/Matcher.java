package lotto.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.Result;

public class Matcher {
    private static final int REPEAT_START = 0;

    public static List<Result> matchResult(List<Lotto> tickets, Lotto winningLotto, int bonusLotto) {
        List<Integer> winningNumberResults = matchWinningNumbers(tickets, winningLotto);
        List<Boolean> bonusNumberResults = matchBonusNumber(tickets, bonusLotto);
        return IntStream.range(REPEAT_START, tickets.size())
                .mapToObj(result -> new Result(winningNumberResults.get(result), bonusNumberResults.get(result)))
                .collect(Collectors.toList());
    }

    private static List<Integer> matchWinningNumbers(List<Lotto> tickets, Lotto winningLotto) {
        return tickets.stream().mapToInt(ticket -> Math.toIntExact(
                ticket.getNumbers().stream()
                        .filter(num -> winningLotto.getNumbers().contains(num))
                        .count())).boxed().collect(Collectors.toList());
    }

    private static List<Boolean> matchBonusNumber(List<Lotto> tickets, int bonusLotto) {
        List<Boolean> results = new ArrayList<>();
        tickets.forEach(ticket -> {
            boolean match = ticket.getNumbers().contains(bonusLotto);
            results.add(match);
        });
        return results;
    }
}
