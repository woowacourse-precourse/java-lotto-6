package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.input.Price;

import java.util.List;
import java.util.ArrayList;

public class LotterySystem {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NEED_NUMBER = 6;
    private final String TICKET_CNT = "개를 구매했습니다.";
    private lotto.ErrorMessages ErrorMessages = new ErrorMessages();
    private static int ticketCnt = 0;
    private lotto.input.Price Price = new Price();
    private Draw Draw = new Draw();

    private List<Draw> tickets = new ArrayList<>();


    public void input() {
        ticketCnt = Price.purchase();
    }
    public void draw() {
        for (int i = 0; i < ticketCnt; i++) {
            List<Integer> ticket = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NEED_NUMBER);
            tickets.add(new Draw(ticket));
            new Draw(ticket);
        }
        printTickets();
    }
    private void printTickets() {
        System.out.println(ticketCnt+TICKET_CNT);
        // 방법이 생각안나서 임시로 만듦 => 리팩토링 꼭 해야됨
        for (Draw d : tickets) System.out.println(d.toString());
    }
    public void getNumbers() {

    }
    public void bonus() {

    }

}
