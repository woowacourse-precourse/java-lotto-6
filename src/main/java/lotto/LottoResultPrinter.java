package lotto;

import java.util.List;

public class LottoResultPrinter {

    //당첨된 로또의 개수를 출력
    public long lottoResultPrinter(List<LottoResult> lottoResults) {
        int threeMatchCount = 0;
        int fourMatchedCount = 0;
        int fiveMatchedCount =0;
        int fiveAndBonusMatchedCount = 0;
        int sixMatchedCount = 0;
        int winningAmount = 0;

        for (int i = 0; i < lottoResults.size(); i++) {
            if (lottoResults.get(i).getMatchedNumbers() == 3) {
                threeMatchCount++;
                winningAmount += 5000;
            }
            if (lottoResults.get(i).getMatchedNumbers() == 4) {
                fourMatchedCount++;
                winningAmount += 50000;
            }
            if (lottoResults.get(i).getMatchedNumbers() == 5 && lottoResults.get(i).isMatchedBonusNumber() == false) {
                fiveMatchedCount++;
                winningAmount += 150000;
            }
            if (lottoResults.get(i).getMatchedNumbers() == 5 && lottoResults.get(i).isMatchedBonusNumber() == true) {
                fiveAndBonusMatchedCount++;
                winningAmount += 30000000;
            }
            if (lottoResults.get(i).getMatchedNumbers() == 6) {
                sixMatchedCount++;
                winningAmount += 2000000000;
            }
        }
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+threeMatchCount+"개");
        System.out.println("4개 일치 (50,000원) - "+fourMatchedCount+"개");
        System.out.println("5개 일치 (1,500,000원) - "+fiveMatchedCount+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+fiveAndBonusMatchedCount+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+sixMatchedCount+"개");

        return winningAmount;
    }

    //수익률 계산 후 결과를 출력
    public String calculateLottoProfitRate (long winningAmount, int amount) {
        double profitRate = ((double) (winningAmount) / (amount*1000)) * 100;
        double result = Math.round(profitRate * 10.0) / 10.0;

        return "총 수익률은 "+result+"%입니다.";
    }
}
