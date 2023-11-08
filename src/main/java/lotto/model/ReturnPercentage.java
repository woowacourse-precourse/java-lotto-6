package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReturnPercentage {
    private static final List<String> LOTT_RANK_SET = List.of("3", "4", "5", "5wB", "6");
    private static final int[] LOTTO_WIN_PRIZE = { //money[0] = 3개,money[1] = 4개,money[2] = 5개,money[3] = 5개+보너스,money[4]=6개
            5000,
            50000,
            1500000,
            30000000,
            2000000000
    };
    private ArrayList<String> winLottoCountList = new ArrayList<>();
    public ReturnPercentage(){
    }
    public float getReturnPercentage(ArrayList<String> matchedNumberCountList, String purchasedPrice){
        matchedLottoCountToList(matchedNumberCountList,purchasedPrice);
        int sumOfWinPrize = getTotalWinPrize();
        return Float.parseFloat(String.valueOf(sumOfWinPrize)) / (Float.parseFloat(purchasedPrice) * 10);
    }
    private void matchedLottoCountToList(ArrayList<String> matchedNumberCountList, String purchasedPrice){
        int lottoFrequency = 0;
        for(String number : LOTT_RANK_SET){
            lottoFrequency = Collections.frequency(matchedNumberCountList,number);
            if( lottoFrequency >= 0){
                winLottoCountList.add(String.valueOf(lottoFrequency));
            }
        }
    }
    private int getTotalWinPrize(){
        int sum = 0;
        for(int i = 0; i < winLottoCountList.size(); i++){
            sum += Integer.parseInt(winLottoCountList.get(i)) * LOTTO_WIN_PRIZE[i];
        }
        return sum;
    }
}
