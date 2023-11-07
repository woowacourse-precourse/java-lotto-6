package lotto.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.Result;

public class Computer {
    private static final int REPEAT_START = 0;

    public static List<Result> computeResult(List<Lotto> tickets, Lotto winnigLotto, int bonusLotto) {
        List<Integer> winningNumberResults = drawWinningNumbers(tickets, winnigLotto);
        List<Boolean> bonusNumberResults = drawBonusNumber(tickets, bonusLotto);
        return IntStream.range(REPEAT_START, tickets.size())
                .mapToObj(result -> new Result(winningNumberResults.get(result), bonusNumberResults.get(result)))
                .collect(Collectors.toList());
    }

    private static List<Integer> drawWinningNumbers(List<Lotto> tickets, Lotto winnigLotto) {
        return tickets.stream().mapToInt(ticket -> Math.toIntExact(
                ticket.getNumbers().stream()
                        .filter(num -> winnigLotto.getNumbers().contains(num))
                        .count())).boxed().collect(Collectors.toList());
    }

    private static List<Boolean> drawBonusNumber(List<Lotto> tickets, int bonusLotto) {
        List<Boolean> results = new ArrayList<>();
        tickets.forEach(ticket -> {
            boolean matchNumber = ticket.getNumbers().contains(bonusLotto);
            results.add(matchNumber);
        });
        return results;
    }
}
