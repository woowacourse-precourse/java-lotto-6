package lotto;

import java.util.ArrayList;
import java.util.List;

public class Start {
    Number number = new Number();
    List<List<Integer>> listOfLists;
    List<Integer> userInputlotto;
    private static final String winStaticsMessage = "당첨 통계";
    private static final String _Message = "---";
    private static final String threeWinMessage = "3개 일치 (5,000원) - ";
    private static final String fourWinMessage = "4개 일치 (50,000원) - ";
    private static final String fiveWinMessage = "5개 일치 (1,500,000원) - ";
    private static final String fiveBonusWinMessage = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String sixWinMessage = "6개 일치 (2,000,000,000원) - ";

    public void startLotto(){
        int purchaseNumber = number.getLottoPurchaseNumber();
        repeatCall(purchaseNumber);
        userInputlotto = number.getLottoWinning();
        int bonus = number.getLottoBonus();

        int[] win = winStatistics(purchaseNumber, bonus);
        winOutput(win, purchaseNumber);
    }
    private void repeatCall(int repeatNumber){
        listOfLists = new ArrayList<>();
        for(int i = 0; i < repeatNumber; i++){
            List<Integer> list = number.getLottoRandom();
            listOfLists.add(list);
            System.out.println(listOfLists.get(i));
        }
    }

    private void winOutput(int[] winResult, int purchseNumber){
        System.out.println(threeWinMessage + winResult[3] + "개");
        System.out.println(fourWinMessage + winResult[4] + "개");
        System.out.println(fiveWinMessage + winResult[5] + "개");
        System.out.println(fiveBonusWinMessage + winResult[7] + "개");
        System.out.println(sixWinMessage + winResult[6] + "개");

        double profitRate = revenuRatid(winResult, purchseNumber);
        System.out.println("총 수익률은 "+ String.format("%.1f", profitRate) + "%입니다.");
    }

    private int[] winStatistics(int purchaseNumber, int bonus){
        System.out.println(winStaticsMessage);
        System.out.println(_Message);

        int[] winAllNumber = new int[8];
        for(int i = 0; i < purchaseNumber; i++){
            List<Integer> list = listOfLists.get(i);
            int num = winNum(list);

            if(num == 5 && list.contains(bonus))
               winAllNumber[5]++;
            if(!(num == 5 && list.contains(bonus)))
                winAllNumber[num]++;
        }
        return winAllNumber;
    }
    private int winNum(List<Integer> lottoNumbers){
        int num = 0;
        for(int number : userInputlotto) {
            if (lottoNumbers.contains(number))
                num++;
        }
        return num;
    }
    private double revenuRatid(int[] winResult, int purchseNumber){
        int totalPrize = winResult[3]*5000 + winResult[4]*50000 + winResult[5]*1500000
                + winResult[7]*30000000 + winResult[6]*2000000000;
        int totalCost = purchseNumber * 1000;
        double profitRate = ((double) totalPrize / totalCost) * 100;
        return profitRate;
    }
}
