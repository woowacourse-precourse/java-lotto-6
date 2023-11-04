package lotto.domain;

public record WinningLotto(Lotto numbers, int bonusNumber) {

    public boolean hasBonusNumber(int count, Lotto playerNumbers) {
        return count == 5 && playerNumbers.getNumbers().contains(bonusNumber);
    }
}
