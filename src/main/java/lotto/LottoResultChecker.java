package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResultChecker {
    private final WinningLotto winningLotto;

    public LottoResultChecker(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public List<Result> getResults(List<Lotto> lottos) {
        return lottos.stream()
                .map(this::check)
                .collect(Collectors.toList());
    }

    private Result check(Lotto lotto) {
        int matchingNumbers = winningLotto.getNumbers().stream()
                .filter(lotto::hasNumber)
                .toList()
                .size();

        boolean bonus = lotto.hasNumber(winningLotto.getBonus());

        return Result.from(matchingNumbers, bonus);
    }
}