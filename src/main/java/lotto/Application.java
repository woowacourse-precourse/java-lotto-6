package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseMoney = Integer.parseInt(Console.readLine());
        /* 추가할 것 : 입력한 구입금액이 1000원으로 나누어 떨어지지 않을 경우 예외처리한다. */

        int ticketNumber = purchaseMoney / 1000;
        System.out.printf("\n%d개를 구매했습니다.%n", ticketNumber);

        //로또 발행
        List[] allTickets = new List[ticketNumber];
        Purchase buyingTickets = new Purchase();
        allTickets = buyingTickets.automaticNum(allTickets, ticketNumber);

        List<Integer> numbers = new ArrayList<>();
        Winning win = new Winning();
        int bonus = 0;
        bonus = win.winningBonusNum(numbers, bonus);

        Rank rank = new Rank();
        int[] ranking;
        ranking = rank.rankAndWinning(ticketNumber, allTickets, bonus, numbers);

        Rate rate = new Rate();
        rate.totalRevenue(ranking, purchaseMoney);
    }
}
