package lotto.repository;

import lotto.domain.Lotto;
import lotto.domain.WinningNumber;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class LottoRepository {

    private static final int LOTTO_PRICE = 1000;

    private WinningNumber winningNumber;  // 당첨 로또
    private List<Lotto> myTickets; // 사용자의 로또
    private int purchaseAmount;

    public LottoRepository() {
        this.purchaseAmount = 0;
    }

    /**
     * 구입 금액만큼 로또를 발행한다.
     *
     * @param amount 구입금액
     * @return count 구입한 수량
     */
    public int buyTicket(int amount) {
        purchaseAmount += amount;
        int count = amount / LOTTO_PRICE;
        for (int i = 0; i < count; i++) {
            buyOneTicket();
        }
        return count;
    }

    private void buyOneTicket() {
        myTickets.add(new Lotto(pickUniqueNumbersInRange(1, 45, 6)));
    }

    // 당첨 로또를 저장한다
    public void drawLotto(List<Integer> numbers, int number) {
        winningNumber = new WinningNumber(new Lotto(numbers), number);
    }

    public List<Lotto> getMyTickets() {
        return myTickets;
    }
}
