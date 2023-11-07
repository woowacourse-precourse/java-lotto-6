package lotto.domain.repository;

import java.util.LinkedList;
import java.util.List;
import lotto.domain.Lotto;

public class WinningLottoRepository {
    private static final int DEFAULT = 0;

    private static List<Lotto> winningLotties = new LinkedList<>();

    public static void add(Lotto winningLotto) {
        winningLotties.add(winningLotto);
    }

    public static void clear() {
        winningLotties.clear();
    }

    public static List<Integer> findWinningNumbers() {
        return findByIndex(DEFAULT).getNumbers();
    }

    private static Lotto findByIndex(int index) {
        return winningLotties.get(index);
    }
}
