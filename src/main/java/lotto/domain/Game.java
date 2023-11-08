package lotto.domain;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private Customer customer;
    private List<Integer> winningNum = new ArrayList<>();
    private int bonusNum;
    private double ror;
    private Map<Rank, Integer> statistics = new HashMap<>();

    public Game(Customer customer) {
        this.customer = customer;
        resetStatistics();
    }

    public void createWinningNum(List<Integer> input) {
        this.winningNum = input;
    }

    public void createBonusNum(int input) {
        this.bonusNum = input;
    }

    public void checkResult() {
        for (Lotto lotto : customer.getLottos()) {
            int sameCount = (int) lotto.getNumbers().stream().filter(winningNum::contains).count();
            boolean haveBonus = lotto.getNumbers().contains(bonusNum);

            switch (sameCount){
                case 6:
                    statistics.put(Rank.FIRST, statistics.get(Rank.FIRST) + 1);
                case 5:
                    if(haveBonus) statistics.put(Rank.SECOND, statistics.get(Rank.SECOND) + 1);
                    else statistics.put(Rank.THIRD, statistics.get(Rank.THIRD) + 1);
                case 4:
                    statistics.put(Rank.FOURTH, statistics.get(Rank.FOURTH) + 1);
                case 3:
                    statistics.put(Rank.FIFTH, statistics.get(Rank.FIFTH) + 1);
            }
        }
    }

    public void showStatistics() {
        long totalReward = 0L;
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            totalReward += rank.getReward() * statistics.get(rank);
            System.out.println(rank + " - " + statistics.get(rank) + "개");
        }
        ror = totalReward / (long)customer.getBuyMoney() * 100;

        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        String formattedValue = decimalFormat.format(ror);

        System.out.println("총 수익률은 " + formattedValue + "%입니다.");
    }

    private void resetStatistics() {
        for (Rank rank : Rank.values()) {
            statistics.put(rank, 0);
        }
    }
}
