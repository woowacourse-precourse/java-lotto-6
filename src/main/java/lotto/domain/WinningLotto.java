package lotto.domain;

public record WinningLotto(Lotto numbers, int bonusNumber) {

    public boolean hasBonusNumber(int rank, Lotto playerNumbers) {
        return Ranking.THIRD.isThirdRank(rank) && playerNumbers.getNumbers().contains(bonusNumber);
    }

    public static WinningLotto generateWinningLotto(Lotto numbers, int bonusNumber) {
        return new WinningLotto(numbers, bonusNumber);
    }
}
