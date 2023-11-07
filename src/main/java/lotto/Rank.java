package lotto;

import java.util.List;

public class Rank {
    public int[] rankAndWinning(int lottoTickets, List[] allTickets, int bonus, List<Integer> numbers) {
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
        return rank;
    }
}
