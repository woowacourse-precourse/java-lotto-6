package lotto.view;

import lotto.constants.StringStore;
import lotto.model.Lotto;

import java.text.DecimalFormat;
import java.util.List;

public class Output {
    public void requestPurchase(){
        System.out.println(StringStore.PURCHASE_START);
    }

    public void confirmPurchase(int numberOfLotto){
        System.out.println(numberOfLotto+ StringStore.PURCHASE);
    }

    public void purchasedLottoNumbers(Lotto lotto){
        System.out.println(lotto);
    }

    public void requestWinningNumbers(){
        System.out.println(StringStore.WINNER_NUMBERS_REQUEST);
    }

    public void requestBonusNumber(){
        System.out.println(StringStore.BONUS_NUMBER_REQUEST);
    }

    public void resultStatistics(List<Integer> ranks){
        System.out.println(StringStore.STATISTICS);
        for(int i=4;i>=0;i--)
        {
            System.out.println(StringStore.LOTTO_RANK[i]+ ranks.get(i)+"개");
        }
    }

    public void profitPercentage(double totalProfitPercentage){
        totalProfitPercentage = (double) Math.round(totalProfitPercentage * 10) / 10;
        System.out.printf("총 수익률은 %.1f%%입니다.\n",totalProfitPercentage);
    }

    public void printErrorMessage(){
        System.out.println(StringStore.INPUT_PRICE_ERROR_MESSAGE);
    }
}
