package lotto;
import java.util.ArrayList;

public class Output {
    
    public static void resultPrint(ArrayList<LottoResult> lottoResults,int priceAmount) {
        LottoResult[] allLottoResults = LottoResult.values();

        System.out.println("당첨 통계\n" + //
                "---");

        int matchCount = 0;

        for (int i = 3; i < allLottoResults.length; i++) {
            isMatch(allLottoResults[i], lottoResults);
        }

        calculateLottoEarnings(lottoResults, priceAmount);
    }


    private static void isMatch(LottoResult selectedResult, ArrayList<LottoResult> lottoResults) {
        int matchCount = 0;

        for (LottoResult lottoResult : lottoResults) {
            if (lottoResult == selectedResult) {
                matchCount++;
            }
        }

        if (selectedResult.getBonusMatch()) {
            System.out.println(selectedResult.getMatch() + "개 일치, 보너스 볼 일치 (" + selectedResult.getStringPrize() + "원) - " + matchCount);
            return;
        }

        System.out.println(selectedResult.getMatch() + "개 일치 (" + selectedResult.getStringPrize() + "원) - " + matchCount);
    }

    private static void calculateLottoEarnings(ArrayList<LottoResult> lottoResults, int priceAmount) {
        int totalPrice = 0;
        double benefit = 0;
        for (LottoResult lottoResult : lottoResults) {
            totalPrice += lottoResult.getPrice();
        }

        if (totalPrice != 0) 
            benefit = Math.round(priceAmount / totalPrice);

        System.out.println("총 수익률은 " + benefit + "% 입니다.");
    }
}
