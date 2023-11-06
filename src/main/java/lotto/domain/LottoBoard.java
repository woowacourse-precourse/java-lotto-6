package lotto.domain;

import java.util.HashMap;

public class LottoBoard {
    final static int PRICE = 1000;
    static int count = 0;
    private int tickets;
    private HashMap<Integer, Lotto> lottoBoard = new HashMap<>();

    public LottoBoard(Integer money) {
        validate(money);
        this.tickets = moneyToTicket(money);
        System.out.println(this.tickets);
    }

    private void validate(Integer money) {
        // TODO: 금액 예외 처리
    }

    private int moneyToTicket(Integer money) {
        return money / PRICE;
    }

    private void putLotto(Lotto lotto) {
        lottoBoard.put(count++, lotto);
    }

}
