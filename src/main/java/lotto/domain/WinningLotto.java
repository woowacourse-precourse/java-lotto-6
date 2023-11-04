package lotto.domain;

public record WinningLotto(Lotto numbers, int bonusNumber) {

    public boolean hasBonusNumber(int count, Lotto playerNumbers) {
        return count == Ranking.THIRD.getRank() && playerNumbers.getNumbers().contains(bonusNumber);
    }
}
