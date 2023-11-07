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
        int purchaseAmount = Integer.parseInt(Console.readLine());
        /* 추가할 것 : 입력한 구입금액이 1000원으로 나누어 떨어지지 않을 경우 예외처리한다. */

        int lottoTickets = purchaseAmount / 1000;
        System.out.printf("\n%d개를 구매했습니다.%n", lottoTickets);

        //로또 발행
        List[] allTickets = new List[lottoTickets];
        for (int i = 0; i < lottoTickets; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers.sort(Comparator.naturalOrder());
            allTickets[i] = numbers;
            System.out.println(numbers);
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");
        String a = Console.readLine();
        String[] winningNumbers = a.split(",");

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < winningNumbers.length; i++) {
            int x = Integer.parseInt(winningNumbers[i]);
            if (!numbers.contains(x)) {
                numbers.add(x);
            }
        }
        Lotto lotto = new Lotto(numbers);

        //나중에 보너스 번호가 당첨 번호와 중복 될 경우의
        //예외처리로 변경할 것.
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonus = Integer.parseInt(Console.readLine());
        while (numbers.contains(bonus)) {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            bonus = Integer.parseInt(Console.readLine());
        }
        //numbers.add(bonus);

        //당첨여부
        int[] rank = new int[6];
        int includedBonus = 0;
        for (int i = 0; i < lottoTickets; i++) {
            if (allTickets[i].contains(bonus)) {
                includedBonus = 1;
            }
            allTickets[i].retainAll(numbers);
            if (allTickets[i].size() == 3) {
                rank[5] += 1;
            } else if (allTickets[i].size() == 4) {
                rank[4] += 1;
            } else if (allTickets[i].size() == 5 && includedBonus == 1) {
                rank[2] += 1;
            } else if (allTickets[i].size() == 5) {
                rank[3] += 1;
            } else if (allTickets[i].size() == 6) {
                rank[1] += 1;
            }
        }

        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.printf("""
                        3개 일치 (5,000원) - %d개
                        4개 일치 (50,000원) - %d개
                        5개 일치 (1,500,000원) - %d개
                        5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
                        6개 일치 (2,000,000,000원) - %d개%n""",
                rank[5], rank[4], rank[3], rank[2], rank[1]);

        double prizeMoney = 5000 * rank[5] + 50000 * rank[4] + 1500000 * rank[3] + 30000000 * rank[2] + 2000000000 * rank[1];
        double rateOfReturn = (prizeMoney / purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", Math.round(rateOfReturn * 10) / 10.0);
    }
}
