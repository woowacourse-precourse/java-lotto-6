package lotto;

public class LottoResultChecker {
    private final Lotto lotto;
    private final WinningLotto winningLotto;

    public LottoResultChecker(Lotto lotto, WinningLotto winningLotto) {
        this.lotto = lotto;
        this.winningLotto = winningLotto;
    }

    public Result getResult() {

        int matchingNumbers = (int) lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .distinct()
                .count();

        boolean bonus = false;
        if (lotto.getNumbers().contains(winningLotto.getBonus())) bonus = true;

        return Result.from(matchingNumbers, bonus);
    }
}
