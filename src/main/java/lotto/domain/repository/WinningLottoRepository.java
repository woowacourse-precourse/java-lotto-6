package lotto.domain.repository;

import java.util.LinkedList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.WinningLotto;
import lotto.domain.WinningNumber;

public class WinningLottoRepository {
    private static final int DEFAULT = 0;

    private static List<WinningLotto> winningLotties = new LinkedList<>();

    public static void add(WinningLotto winningLotto) {
        winningLotties.add(winningLotto);
    }

    public static void clear() {
        winningLotties.clear();
    }

    public static WinningNumber findWinningNumbers() {
        return findWiningLotto().getWinning();
    }

    public static BonusNumber findBonusNumber() {
        return findWiningLotto().getBonus();
    }

    public static WinningLotto findWiningLotto() {
        return winningLotties.get(DEFAULT);
    }
}
