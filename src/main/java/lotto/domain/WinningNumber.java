package lotto.domain;

import java.util.List;

public class WinningNumber {

    private final List<Integer> winningNumbers;
    private final BonusNumber bonusNumber;

    private WinningNumber(List<Integer> winningNumbers, BonusNumber bonusNumber) {
        validate(winningNumbers, bonusNumber.getBonusNumber());
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumber of(List<Integer> winningNumbers, BonusNumber bonusNumber) {
        return new WinningNumber(winningNumbers, bonusNumber);
    }

    public boolean isWinningNumber(Lotto lotto) {
        int matchCount = (int) lotto.getNumbers().stream().filter(winningNumbers::contains).count();
        boolean matchBonus = lotto.getNumbers().contains(bonusNumber.getBonusNumber());

        return Prize.determinePrize(matchCount, matchBonus).getMatchCount() >= 3;
    }

    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        if (bonusNumber < Lotto.MIN_VALUE || bonusNumber > Lotto.MAX_VALUE) {
            throw new IllegalArgumentException("보너스 번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
