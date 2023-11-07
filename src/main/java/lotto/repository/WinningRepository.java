package lotto.repository;

import lotto.domain.Winning;

public class WinningRepository {

    private static Winning winning;

    public Winning save(Winning saveWinning) {
        winning = saveWinning;
        return winning;
    }

    public Winning find() {
        return winning;
    }

    public void clear() {
        winning = null;
    }
}
