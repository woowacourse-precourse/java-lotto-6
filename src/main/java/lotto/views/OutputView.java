package lotto.views;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import lotto.configs.Constant;
import lotto.configs.Prize;
import lotto.models.Lotto;

public class OutputView {
    public void printGetPurchaseAmount(){
        System.out.println(Constant.VIEW_PURCHASE);
    }
    public void printLotteries(List<Lotto> lotteries){
        System.out.println(String.format(Constant.VIEW_LOTTO_COUNT, lotteries.size()));
        for(Lotto lotto: lotteries){
            System.out.println(lotto);
        }
    }
    public void printGetWinningNumber(){
        System.out.println(Constant.VIEW_WINNING_NUMBER);
    }
    public void printGetBonusNumber(){
        System.out.println(Constant.VIEW_BONUS_NUMBER);
    }

    public void printPrizes(HashMap<Prize, Integer> prizes) {
        System.out.println(
                String.format(
                        Constant.VIEW_STATISTIC,
                        prizes.get(Prize.FIFTH),
                        prizes.get(Prize.FOURTH),
                        prizes.get(Prize.THIRD),
                        prizes.get(Prize.SECOND),
                        prizes.get(Prize.FIRST)
                )
        );
    }

    public void printResult(double rateOfIncomes) {
        DecimalFormat df = new DecimalFormat("0.##");
        System.out.println(String.format(Constant.VIEW_RATE_OF_AMOUNT,  df.format(rateOfIncomes)));
    }
}
