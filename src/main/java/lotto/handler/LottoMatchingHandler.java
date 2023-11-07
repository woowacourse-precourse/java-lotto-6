package lotto.handler;

import lotto.model.Lotto;
import lotto.model.WinningLotto;


public class LottoMatchingHandler {
    private static LottoMatchingHandler instance;

    private LottoMatchingHandler() {}

    public static LottoMatchingHandler getInstance() {
        if(instance == null) {
            instance = new LottoMatchingHandler();
        }
        return instance;
    }

    // 같은 수 찾기
    public int countMatchingNum(Lotto lotto, WinningLotto winningLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(n -> winningLotto.getWinningNumbers().contains(n))
                .count();
    }


    public boolean isMatchingBonusNum(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
