package lotto;

/**
 * @author 김지환
 * 
 * 로또 출력을 담당하는 클래스
 */
public class LottoPrint {
    
    /*로또 구매갯수 출력 메서드*/
    public void printPurchaseLottoNumbers(int userAmount) {
        int purchaseAmount = userAmount;
        int numberOfPurchasedLotto = purchaseAmount / 1000;
        System.out.println(numberOfPurchasedLotto + "개를 구매했습니다.");
    }
    
    /*당첨 통계 및 당첨갯수 출력 메서드*/
    public void printMatchStatistics(int[] matchCount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (MatchType matchType : MatchType.values()) {
            int count = matchCount[matchType.ordinal()];
            System.out.println(matchType.getOutputString()+" - " + count + "개");
        }
    }
    
    /*수익률 출력 메서드*/
    public void rateOfReturn(int[] matchCount, int purchaseAmount) {
        double rateOfReturn = calculateRateOfReturn(matchCount, purchaseAmount);
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
    
    /*수익률 계산을 위한 메서드*/
    private double calculateRateOfReturn(int[] matchCount, int purchaseAmount) {
        int totalPrize = 0;
        
        for (int i = 0; i < matchCount.length; i++) {
            totalPrize += matchCount[i] * MatchType.values()[i].getPrize();
        }
        return Math.round(totalPrize / (double) purchaseAmount * 1000) / 10.0;
    }
    
}
