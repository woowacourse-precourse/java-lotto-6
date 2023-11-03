package lotto.game;

import camp.nextstep.edu.missionutils.Console;

import lotto.domain.Ticket;
import lotto.type.ErrorCode;


public class Game {

    public void play() {
        int totalTicketCount;
        try {
            totalTicketCount = buyTicket();
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorCode.INVALID_MONEY_TO_BUY.getDescription());
            totalTicketCount = buyTicket();
        }

        System.out.println(totalTicketCount + "개를 구매했습니다.");
    }

    private int buyTicket() {
        System.out.println("구입금액을 입력해 주세요.");
        int moneyInput = Integer.parseInt(Console.readLine());
        Ticket ticket = new Ticket();
        ticket.setCount(moneyInput);
        return ticket.getCount();
    }

}
