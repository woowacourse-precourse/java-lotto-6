package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class CalculateStats {
    enum Prize {
        FIFTH(3, false, "5,000", 5000),
        FOURTH(4, false, "50,000", 50000),
        THIRD(5, false, "1,500,000", 1500000),
        SECOND(5, true, "30,000,000", 30000000),
        FIRST(6, false, "2,000,000,000", 2000000000),
        NONE(0, false, "", 0);

        private final int correctPrizeNums;
        private final boolean correctBonusNum;
        private final String information;
        private final int prizeAmount;

        Prize(int correctPrizeNums, boolean correctBonusNum, String information, int prizeAmount) {
            this.correctPrizeNums = correctPrizeNums;
            this.correctBonusNum = correctBonusNum;
            this.information = information;
            this.prizeAmount = prizeAmount;
        }

        public int getCorrectPrizeNums() {
            return correctPrizeNums;
        }

        public boolean isCorrectBonusNum() {
            return correctBonusNum;
        }

        public String getInformation(){
            return information;
        }

        public int getPrizeAmount() {
            return prizeAmount;
        }
    }

    public static int[] calculatePrize(List<Lotto> lottoTickets, UserNumberInput userNumberInput) {
        List<Integer> prizeNumbers = userNumberInput.prizeNumberInput();
        int bonusNumber = userNumberInput.bonusInput();

        int[] prizeCounts = new int[Prize.values().length];
        int[] matchingNumbersCounts = new int[7];

        boolean correctBonusNum = false;
        for (Lotto lotto : lottoTickets) {
            int correctPrizeNums = 0;
            correctBonusNum = lotto.getNumbers().contains(bonusNumber);

            for (int ticketNumber : lotto.getNumbers()) {
                if (prizeNumbers.contains(ticketNumber)) {
                    correctPrizeNums++;
                }
            }
            matchingNumbersCounts[correctPrizeNums]++;
            Prize prize = determinePrize(correctPrizeNums, correctBonusNum);
            prizeCounts[prize.ordinal()]++;

        }
        int totalPrize = resultPrint(correctBonusNum, matchingNumbersCounts);
        double profitRate = calculateProfitRate(totalPrize, lottoTickets);
        System.out.println("총 수익률은 " + profitRate + "% 입니다.");

        return prizeCounts;
    }

    public static double calculateProfitRate(int totalPrize, List<Lotto> lottoTickets){
        int totalCost = lottoTickets.size() * 1000;

        return ((double) totalPrize / totalCost) * 100;
    }

    private static Prize determinePrize(int correctPrizeNums, boolean correctBonusNum){
        for (Prize prize : Prize.values()){
            if(prize.getCorrectPrizeNums() == correctPrizeNums && prize.isCorrectBonusNum() == correctBonusNum){
                return prize;
            }
        }
        return Prize.NONE;
    }

    public static int resultPrint(boolean correctBonusNum, int[] matchingNumbersCounts) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        int totalPrize = 0;

        for (int i = 3; i < matchingNumbersCounts.length; i++) {
            if (i == 5 && correctBonusNum){
                System.out.println("5개 일치, 보너스 볼 일치 (" + Prize.values()[i - 3].getInformation() + "원) - " + matchingNumbersCounts[i] + "개");
                totalPrize += Prize.values()[i -3].getPrizeAmount() * matchingNumbersCounts[i];
            }else {
                System.out.println(i + "개 일치 (" + Prize.values()[i - 3].getInformation() + "원) - " + matchingNumbersCounts[i] + "개");
                totalPrize += Prize.values()[i - 3].getPrizeAmount() * matchingNumbersCounts[i];
            }
        }
        return totalPrize;
    }
}
