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
    public static void compareValueStart(List<Integer> winningBalls,
                                         List<List<Integer>> lottoRepo,
                                         Integer bonusBall,
                                         Integer amount){
//        System.out.println(lottoRepo);
//        System.out.println(winningBalls);
        // 당첨볼을 정수리스트로 변환
        for (int i = 0; i<lottoRepo.size(); i++){
            // 각 로또와 당첨볼을 받아 비교하는 함수
            compareLottoValue(winningBalls, lottoRepo.get(i), bonusBall);
        }
        // 함수 추가: 로또의 갯수만큼 전달 시(위의 반복문 수행완료시) 총 수익률 계산하고 로또결과와 수익률 출력하는 함수 호출
        lottoPrize();
//        getRateOfTurn(amount);
        OutputView.winningStatistics(amount);
        OutputView.winningRate(getRateOfTurn(amount));
    }



    public static void compareLottoValue(List<Integer> winningBalls, List<Integer> lottoBalls, Integer bonusBall){ // 점수 비교하는 함수
        resultScore = 0;
        for(int j = 0; j<LOTTO_LEN; j++){ // 생성된 로또를 반복하며
            if(winningBalls.contains(lottoBalls.get(j))){
                // 자동으로 같은 자리가 비교되어 값만 같은지 알면 됨
                resultScore +=1;
            }
        }
        // 점수가 6점일 경우
        if(resultScore == FIRST_RANK){
            firstRankScoreAdd();
        }

        // 점수가 5점일 경우 2등을 가리기 위한 함수 호출
        if(resultScore == SECOND_OR_THIRD){
            secondRankChance(lottoBalls, bonusBall);
        }
        lottoRank(); // 열거형(WinningAmounts)의 count값을 올릴 것임

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
//        System.out.println(resultScore);
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
            // 일단 NO_AMOUNT (score == 0) 이용해서 작성
        }
        // 이 함수에서는 몇개가 똑같은지에 대한 점수(resultScore)를 받아서 열거형(WinningAmounts)의 score와 비교 후 count값을 올릴 것임
    }
    public static void lottoPrize(){
        int firstPrize = WinningAmounts.FIRST_AMOUNT.getPrize();
        int secondPrize = WinningAmounts.SECOND_AMOUNT.getPrize();
        int thirdPrize = WinningAmounts.THIRD_AMOUNT.getPrize();
        int forthPrize = WinningAmounts.FORTH_AMOUNT.getPrize();
        int fifthPrize = WinningAmounts.FIFTH_AMOUNT.getPrize();
        resultMoney += (firstPrize + secondPrize + thirdPrize+ forthPrize + fifthPrize);
//        System.out.println(resultMoney);
    }

    public static int getResultMoney(){
        return resultMoney;
    }

    public static double getRateOfTurn(Integer amount){
        double turn = (double)resultMoney / amount ;
//        System.out.println(turn);
        double rateOfTurn =  (double) Math.round(turn * 10000) / 100;
//        DecimalFormat df = new DecimalFormat("0.000");
//        String resultTurn = String.format("%.1f", turn*100);
//        System.out.println(Integer.parseInt(resultTurn));
//        Integer.parseInt(resultTurn);
        return rateOfTurn; // 수익률 계산 공식 : 상금 / 사용한 금액
    }
}