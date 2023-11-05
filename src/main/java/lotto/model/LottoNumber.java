package lotto.model;

import java.util.List;

public record LottoNumber(int number) {

    public LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public int calculateMatchingCount(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream().filter(num -> num == number).count();
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return number == bonusNumber;
    }

    public int calculateMatchingCountWithWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        int matchingCount = calculateMatchingCount(winningNumbers);
        return (matchingCount == 5 && hasBonusNumber(bonusNumber)) ? 6 : matchingCount;
    }
}
