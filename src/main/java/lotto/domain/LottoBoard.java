package lotto.domain;

import java.util.HashMap;

public class LottoBoard {
    static int count = 0;
    private int tickets;
    private HashMap<Integer, Lotto> lottoBoard = new HashMap<>();

    private LottoBoard(int tickets) {
        this.tickets = tickets;
    }

    private void putLotto(Lotto lotto) {
        lottoBoard.put(count++, lotto);
    }

}
