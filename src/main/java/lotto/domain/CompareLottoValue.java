package lotto.domain;

import lotto.view.OutputView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

public class CompareLottoValue {
    public static final int LOTTO_LEN = 6;
    public static final int FIRST_RANK = 6;
    public static final int SECOND_OR_THIRD = 5;
    static int resultScore = 0;
    static int resultMoney = 0;
    private static final String DECIMAL_FORMAT = "###,##0.0";
    public static void compareValueStart(List<Integer> winningBalls,
                                         List<List<Integer>> lottoRepo,
                                         Integer bonusBall,
                                         Integer amount){

        for (int i = 0; i<lottoRepo.size(); i++){
            compareLottoValue(winningBalls, lottoRepo.get(i), bonusBall);
        }
        lottoPrize();
        OutputView.winningStatistics(amount);
        OutputView.winningRate(getRateOfTurn(amount));
    }



    public static void compareLottoValue(List<Integer> winningBalls, List<Integer> lottoBalls, Integer bonusBall){
        resultScore = 0;
        for(int j = 0; j<LOTTO_LEN; j++){
            if(winningBalls.contains(lottoBalls.get(j))){
                resultScore +=1;
            }
        }

        if(resultScore == FIRST_RANK){
            firstRankScoreAdd();
        }

        if(resultScore == SECOND_OR_THIRD){
            secondRankChance(lottoBalls, bonusBall);
        }
        lottoRank();

    }

    public static Integer secondRankChance(List<Integer> lottoBalls, Integer bonusBall){
        for(int lottoBall : lottoBalls){
            if(lottoBall == bonusBall){
                resultScore += 1;
            }
        }
        return resultScore;
    }

    public static Integer firstRankScoreAdd(){
        resultScore += 1;
        return resultScore;
    }

    public static void lottoRank(){
        if(resultScore == 7){
            WinningAmounts firstAmount = WinningAmounts.FIRST_AMOUNT;
            firstAmount.count += 1;
        } else if (resultScore == 6) {
            WinningAmounts secondAmount = WinningAmounts.SECOND_AMOUNT;
            secondAmount.count +=1;
        } else if(resultScore ==5){
            WinningAmounts thirdAmount = WinningAmounts.THIRD_AMOUNT;
            thirdAmount.count +=1;
        }else if (resultScore ==4){
            WinningAmounts forthAmount = WinningAmounts.FORTH_AMOUNT;
            forthAmount.count +=1;
        } else if (resultScore ==3) {
            WinningAmounts fifthAmount = WinningAmounts.FIFTH_AMOUNT;
            fifthAmount.count +=1;
        } else{
            WinningAmounts noAmount = WinningAmounts.NO_AMOUNT;
        }

    }
    public static void lottoPrize(){
        int firstPrize = WinningAmounts.FIRST_AMOUNT.getPrize();
        int secondPrize = WinningAmounts.SECOND_AMOUNT.getPrize();
        int thirdPrize = WinningAmounts.THIRD_AMOUNT.getPrize();
        int forthPrize = WinningAmounts.FORTH_AMOUNT.getPrize();
        int fifthPrize = WinningAmounts.FIFTH_AMOUNT.getPrize();
        resultMoney += (firstPrize + secondPrize + thirdPrize+ forthPrize + fifthPrize);
    }

    public static int getResultMoney(){
        return resultMoney;
    }

    public static double getRateOfTurn(Integer amount){
        double turn = ((double) (resultMoney ) / amount ) * 100;
        double rateOfTurn =  Math.round(turn * 100) / 100.0;
        return rateOfTurn;
    }
}