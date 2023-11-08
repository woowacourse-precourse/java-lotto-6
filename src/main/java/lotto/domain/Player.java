package lotto.domain;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Player {
    public final int FisrtWinnerMatchNum = 6;
    public final int LastWinnerMatchNum = 3;
    public final int checkBonusNumPoint = 5;
    List<Lotto> lottos;
    public int money;
    public int lottoTicketNum;
    int[] winningScore;

    public Player() {
        this.winningScore = new int[7];
        lottos = new ArrayList<>();
    }

    public void createLotto(int num) {
        for (int i = 0; i < num; i++) {
            List<Integer> temp = new RandomNumber().getNumbers();
            temp = temp.stream()
                    .sorted()
                    .collect(Collectors.toList());

            Lotto tempLotto = new Lotto(temp);
            lottos.add(tempLotto);
        }
    }


    public void displayLotto() {
        for (Lotto lotto : this.lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void countInRankingEachRank() {
        for (Lotto lotto : this.lottos) {
            if (lotto.countSameNum() < 1) continue;
            this.winningScore[lotto.countSameNum() - 1]++;
            lotto.checkHasBonus();
            if (lotto.countWinningNum == checkBonusNumPoint && lotto.hasBonus) {
                this.winningScore[6]++;
                this.winningScore[4]--;
            }

        }
    }

    public double calculateReward() {
        int rewardMoney = 0;
        for (Lotto lotto : this.lottos) {
            rewardMoney += Ranking.findByRanking(lotto.countWinningNum, lotto.hasBonus).getReward();
        }
        return rewardMoney;
    }

    public void printWinningScore() {
        DecimalFormat df = new DecimalFormat("###,###,###,###");
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = LastWinnerMatchNum; i < FisrtWinnerMatchNum + 1; i++) {
            System.out.printf("%d개 일치 (%s원) - %d개\n", i, df.format(Ranking.findByRanking(i, false).getReward()), winningScore[i-1]);
            if (i == checkBonusNumPoint && this.winningScore[6] > 0) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개", checkBonusNumPoint, df.format(Ranking.findByRanking(i, true).getReward()), winningScore[6]);
                System.out.println();
                continue;
            }
            if (i == checkBonusNumPoint && this.winningScore[6] == 0) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개", checkBonusNumPoint, df.format(Ranking.findByRanking(i, true).getReward()), winningScore[6]);
                System.out.println();
                continue;
            }
        }
    }


    public void printProfit() {
        double profit = (calculateReward() / (double) this.money)*100;
        System.out.printf("총 수익률은 %.1f%%입니다.", profit);
        System.out.println();
    }
}
