package lotto;

public record WinningNumbers(Lotto winningLotto, int bonus) {
    public Rank rank(Lotto lotto) {
        return lotto.rank(winningLotto, bonus);
    }
}
