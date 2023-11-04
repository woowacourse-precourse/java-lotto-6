package lotto;

public record WinningNumbers(Lotto winningLotto, int bonus) {
    public RANK rank(Lotto lotto) {
        return lotto.rank(winningLotto, bonus);
    }
}
