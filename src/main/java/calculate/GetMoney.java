package calculate;

import java.util.List;

public class GetMoney {
    List<Integer> number;
    List<List<Integer>> getPurchaseLotto;
    int bonusNumber;
    public GetMoney(List<Integer> number, List<List<Integer>> getPurchaseLotto, int bonusNumber) {
        this.number = number;
        this.getPurchaseLotto = getPurchaseLotto;
        this.bonusNumber = bonusNumber;
        calculateMatchNumber();
    }

    private void calculateMatchNumber() {
        MatchNumber[] winningRanks = MatchNumber.values();
        int []matchCounts = new int[winningRanks.length];

        for(List<Integer>lotto : getPurchaseLotto){
            int count = countMatchingNumbers(lotto,number);
            MatchNumber rank = determineRank(count, lotto.contains(bonusNumber));
            if (rank != null) {
                matchCounts[rank.ordinal()]++;
            }
        }
        displayWinningStatistics(matchCounts);
    }

    private void displayWinningStatistics(int[] matchCounts) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (MatchNumber rank : MatchNumber.values()) {
            int count = matchCounts[rank.ordinal()];
                System.out.println(rank.getDescription() + " - " + count + "개");

        }

        int totalPrize = calculateTotalPrize(matchCounts);
        double earningRate = calculateEarningRate(totalPrize);
        System.out.println("총 수익률은 " + earningRate + "%입니다.");
    }

    private int calculateTotalPrize(int[] matchCounts) {
        int totalPrize = 0;
        for (MatchNumber rank : MatchNumber.values()) {
            totalPrize += rank.getPrize() * matchCounts[rank.ordinal()];
        }
        return totalPrize;
    }

    private double calculateEarningRate(int totalPrize) {
        int totalSpent = getPurchaseLotto.size() * 1000;
        return Math.round(((double) totalPrize / totalSpent) * 1000)/10.0;
    }

    private MatchNumber determineRank(int count, boolean hasBonus) {
        if(count == 6 ){ return MatchNumber.FIRST;
        }
        if(count == 5 && !hasBonus) { return MatchNumber.SECOND;
        }
        if(count == 5){ return MatchNumber.THIRD;
        }
        if(count == 4){ return MatchNumber.FOURTH;
        }
        if(count == 3){ return MatchNumber.FIFTH;
        }
        return null;
    }

    private int countMatchingNumbers(List<Integer> lotto, List<Integer> number) {
        lotto.retainAll(number);
        return lotto.size();
    }

}



