package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
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
        rate(ranking, purchaseMoney);
    }

    public static void rate(int[] rank, int purchaseMoney) {
        double prizeMoney = 5000 * rank[5] + 50000 * rank[4] + 1500000 * rank[3] + 30000000 * rank[2] + 2000000000 * rank[1];
        double rateOfReturn = (prizeMoney / purchaseMoney) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", Math.round(rateOfReturn * 10) / 10.0);
    }
}
