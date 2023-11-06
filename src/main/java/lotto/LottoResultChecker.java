package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResultChecker {
    private final WinningLotto winningLotto;

    public LottoResultChecker(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public Result check(Lotto lotto) {

        int matchingNumbers = (int) lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .distinct()
                .count();

        boolean bonus = lotto.getNumbers().contains(winningLotto.getBonus());

        return Result.from(matchingNumbers, bonus);
    }

    public List<Result> getResults(List<Lotto> lottos) {
        return lottos.stream()
                .map(this::check)
                .collect(Collectors.toList());
    }
}
