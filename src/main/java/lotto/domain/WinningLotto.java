package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final List<Integer> winningLottoNumbers;

    private final int bonusNumber;

    public WinningLotto(List<Integer> winningLottoNumbers, int bonusNumber) {
        winningLottoValidate(winningLottoNumbers,bonusNumber);
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void winningLottoValidate(List<Integer> winningLottoNumbers, int bonusNumber) {
        if (isOverlapBonusNumber(winningLottoNumbers,bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 6개의 당첨번호와 보너스 번호는 중복될수 없습니다.");
        }
    }
    private boolean isOverlapBonusNumber(List<Integer> winningLottoNumbers, int bonusNumber){
        return winningLottoNumbers.contains(bonusNumber);
    }
    public List<Integer> getWinningLottoNumbers() {
        return winningLottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
