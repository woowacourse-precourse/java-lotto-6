package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //예외 처리 - 문자 입력
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String purchaseMoney = Console.readLine();
            Purchase buyingTickets = new Purchase(purchaseMoney);
            int ticketNumber = buyingTickets.numberOfTickets(buyingTickets.getPurchaseMoney());

            //로또 발행
            List[] allTickets = buyingTickets.automaticNum(ticketNumber);

            List<Integer> numbers = new ArrayList<>();
            Winning win = new Winning();
            int bonus = 0;
            numbers = win.winningNum(numbers, bonus);
            bonus = win.bonusNum(numbers, bonus);

            Rank rank = new Rank();
            int[] ranking;
            ranking = rank.rankAndWinning(ticketNumber, allTickets, bonus, numbers);

            Rate rate = new Rate();
            rate.totalRevenue(ranking, buyingTickets.getPurchaseMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
