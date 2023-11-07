package lotto;

import java.util.List;

public class WinningNumbers {
    List<Lotto> winningLottoNumbers;

    public WinningNumbers(List<Lotto> winningLottoNumbers) {
        this.winningLottoNumbers = winningLottoNumbers;
    }

    public int compareWith(Lotto lotto) {
        int userMatchedCount = 0;
        for (Lotto winningLotto : winningLottoNumbers) {
            for (Integer userNumber : lotto.getNumbers()) {
                if (winningLotto.getNumbers().contains(userNumber)) {
                    userMatchedCount++;
                }
            }
        }
        return userMatchedCount;
    }
}
