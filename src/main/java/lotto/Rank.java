package lotto;

import java.util.List;

public class Rank {
    private int[] rank = new int[6];

    public int[] rankAndWinning(int lottoTickets, List[] allTickets, int bonus, List<Integer> numbers) {
        matching(lottoTickets, allTickets, bonus, numbers);
        statistics();
        return rank;
    }

    public void matching(int lottoTickets, List[] allTickets, int bonus, List<Integer> numbers) {
        //당첨여부
        boolean includedBonus = false;
        for (int i = 0; i < lottoTickets; i++) {
            if (allTickets[i].contains(bonus)) {
                includedBonus = true;
            }
            //자동 숫자에 당첨 숫자가 있는가
            int matchingNumCount = 0;
            matchingNumCount = autoNumHasWinningNum(numbers, allTickets, i);
            rank = totalRankCount(matchingNumCount, includedBonus);
        }
    }

    public int autoNumHasWinningNum(List<Integer> numbers, List[] allTickets, int i) {
        int count = 0;
        for (int j = 0; j < numbers.size(); j++) {
            if (allTickets[i].contains(numbers.get(j))) {
                count += 1;
            }
        }
        return count;
    }

    public int[] totalRankCount(int matchingNumCount, boolean includedBonus) {
        int[] rank = new int[6];
        if (matchingNumCount == 3) {
            rank[5] += 1;
        }
        if (matchingNumCount == 4) {
            rank[4] += 1;
        }
        if (matchingNumCount == 5 && includedBonus) {
            rank[2] += 1;
        }
        if (matchingNumCount == 5) {
            rank[3] += 1;
        }
        if (matchingNumCount == 6) {
            rank[1] += 1;
        }
        return rank;
    }

    public void statistics() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.printf("""
                        3개 일치 (5,000원) - %d개
                        4개 일치 (50,000원) - %d개
                        5개 일치 (1,500,000원) - %d개
                        5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
                        6개 일치 (2,000,000,000원) - %d개%n""",
                rank[5], rank[4], rank[3], rank[2], rank[1]);
    }
}
