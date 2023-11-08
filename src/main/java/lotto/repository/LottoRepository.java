package lotto.repository;

import lotto.domain.Lotto;
import lotto.domain.WinningNumber;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class LottoRepository {

    private static final int LOTTO_PRICE = 1000;
    private static final int BALL_QUANTITY = 6;

    private WinningNumber winningNumber;  // 당첨 로또
    private List<Lotto> myTickets; // 사용자의 로또
    private int purchaseAmount;

    public LottoRepository() {
        this.purchaseAmount = 0;
        this.myTickets = new ArrayList<>();
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
    public void drawLotto(Lotto lotto, int number) {
        winningNumber = new WinningNumber(lotto, number);
    }


    public int[] confirmTickets() {
        int[] result = new int[BALL_QUANTITY + 2];
        for (Lotto ticket : myTickets) {
            result[confirmTicket(ticket)]++;
        }
        return result;
    }

    /**
     * 발행한 로또 한 장의 결과를 확인한다.
     *
     * @param ticket Lotto 클래스
     * @return 일치하는 숫자의 수를 반환
     * (단, 5개가 일치하고 보너스볼도 일치하면 BALL_QUANTITY+1 을 반환)
     */
    private int confirmTicket(Lotto ticket) {
        int same = 0;
        for (int number : ticket.getNumbers()) {
            if (winningNumber.getWinningNumber().contains(number))
                same++;
        }

        if (same == 5 && ticket.getNumbers().contains(winningNumber.getBonusNumber()) || same > 5) {
            return same + 1;
        }

        return same;
    }


    public List<Lotto> getMyTickets() {
        return myTickets;
    }

    // 테스트용 메서드
    public WinningNumber getWinningNumber() {
        return winningNumber;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
