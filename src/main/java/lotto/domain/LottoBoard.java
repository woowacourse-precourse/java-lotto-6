package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;

public class LottoBoard {
    final static int PRICE = 1000;
    private int tickets;
    private HashMap<Integer, Lotto> lottoBoard = new HashMap<>();

    public LottoBoard(Integer money) {
        validate(money);
        this.tickets = moneyToTicket(money);
        System.out.println(this.tickets + "개를 구매했습니다.");

        loadLottoboard();
    }

    private void loadLottoboard() {
        for (int i = 0; i < this.tickets; i++) {
            lottoBoard.put(i, new Lotto(spanLotto()));
        }
        for (int j = 0; j < this.tickets; j++) {
            System.out.println(lottoBoard.get(j));
        }
    }

    private List<Integer> spanLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private void validate(Integer money) {
        if (money < PRICE) throw new IllegalArgumentException("1000원 이상 입력해주세요.");
        else if (money % PRICE != 0) throw new IllegalArgumentException("1000단위로 입력해주세요.");
    }


    private int moneyToTicket(Integer money) {
        return money / PRICE;
    }

    public Lotto getOneLotto(int i) {
        return lottoBoard.get(i);
    }

    public int getTickets() {
        return tickets;
    }
}
