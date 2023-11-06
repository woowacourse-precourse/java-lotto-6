package lotto.model;

import java.util.List;

public class WinningLotto extends Lotto {
    private BonusNumber bonusNumber;

    private WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        // 여기서 List의 size가 6이 아니면 유효성검사 실패
        super(winningNumbers);
        this.bonusNumber = BonusNumber.getInstance(bonusNumber);
    }

    public static WinningLotto getInstance(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    // 당첨로또와 비교하여 등수 내는 메서드 필요함
}
