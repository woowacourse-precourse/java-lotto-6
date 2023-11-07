package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        // TODO: 당첨 번호의 유효성을 검사하는 로직 구현
        // 당첨 번호가 6개인지 확인
        // 보너스 번호가 당첨 번호와 중복되지 않는지 확인
    }

    public boolean isWinningNumber(LottoNumber lottoNumber) {
        // TODO: 주어진 LottoNumber가 당첨 번호 중 하나인지 확인하는 로직 구현
        return false;
    }

    public boolean isBonusNumber(LottoNumber lottoNumber) {
        // TODO: 주어진 LottoNumber가 보너스 번호인지 확인하는 로직 구현
        return false;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
