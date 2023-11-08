package lotto;

import java.text.NumberFormat;

public class LottoPrint {
    
    public void printPurchaseLottoNumbers(int userAmount) {
        int purchaseAmount = userAmount;
        int numberOfPurchasedLotto = purchaseAmount / 1000;
        System.out.println(numberOfPurchasedLotto + "개를 구매했습니다.");
    }
    
    public void printMatchStatistics(int[] matchCount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (MatchType matchType : MatchType.values()) {
            int prize = matchType.getPrize();
            int count = matchCount[matchType.ordinal()];
            System.out.println(matchType.getOutputString()+" - " + count + "개");
        }
    }
    
    public void rateOfReturn(int[] matchCount, int purchaseAmount) {
        double rateOfReturn = calculateRateOfReturn(matchCount, purchaseAmount);
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
    
    private double calculateRateOfReturn(int[] matchCount, int purchaseAmount) {
        int totalPrize = 0;
        
        for (int i = 0; i < matchCount.length; i++) {
            totalPrize += matchCount[i] * MatchType.values()[i].getPrize();
        }
        return Math.round(totalPrize / (double) purchaseAmount * 1000) / 10.0;
    }
    
}
