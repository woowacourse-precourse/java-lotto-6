package lotto;
import java.util.List;
import java.util.ArrayList;

public class Output {

    public static void lottoInfoPrint( List<List<Integer>> userNumbers) {
        StringBuilder sb = new StringBuilder();
        sb.append(userNumbers.size() +"개를 구매했습니다. \n");
        for (List<Integer> numberInfos : userNumbers) {
            sb.append("[");
            sb.append(numberInfos.get(0));
            for (int i = 1; i < numberInfos.size(); i++) {
                sb.append(", " + numberInfos.get(i));
            }

            sb.append("]" + "\n");
        }

        System.out.println(sb);
    }
    
    public static void resultPrint(ArrayList<LottoResult> lottoResults) {
        LottoResult[] allLottoResults = LottoResult.values();

        System.out.println("당첨 통계\n" + //
                "---");

        for (int i = 3; i < allLottoResults.length; i++) {
            isMatch(allLottoResults[i], lottoResults);
        }
    }


    public static double calculateLottoEarnings(ArrayList<LottoResult> lottoResults, double priceAmount) {
        int totalPrice = 0;
        double benefit = 0;
        for (LottoResult lottoResult : lottoResults) {
            totalPrice += lottoResult.getPrice();
        }

        if (totalPrice != 0) 
            benefit = Math.round(totalPrice / priceAmount * 1000) / 10.0;

         System.out.println("총 수익률은 " + benefit + "%입니다.");

         return benefit;
    }


    private static void isMatch(LottoResult selectedResult, ArrayList<LottoResult> lottoResults) {
        int matchCount = 0;

        for (LottoResult lottoResult : lottoResults) {
            if (lottoResult == selectedResult) {
                matchCount++;
            }
        }

        if (selectedResult.getBonusMatch()) {
            System.out.println(selectedResult.getMatch() + "개 일치, 보너스 볼 일치 (" + selectedResult.getStringPrize() + "원) - " + matchCount + "개");
            return;
        }

        System.out.println(selectedResult.getMatch() + "개 일치 (" + selectedResult.getStringPrize() + "원) - " + matchCount +"개");
    }

}

