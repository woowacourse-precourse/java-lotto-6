package lotto.Print;

import lotto.Lotto.Lotto;
import lotto.Lotto.LottoGame;
import lotto.Result.Result;
import lotto.Result.WinningResult;

import java.util.List;
import java.util.Map;

public class Print {

    //로또 구입 메세지 출력
    public static void printBuyLotto() {
        System.out.println(Message.INPUT_LOTTO_PRICE_MESSAGE);
    }

    //구입한 로또 개수와 번호 출력
    public static void printPaidLottoResult(List<Lotto> paidLottos,int lottoBuyCount){
        System.out.printf("\n"+Message.INFORM_LOTTO_COUNT_MESSAGE+"\n",lottoBuyCount);
        for(Lotto paidLotto : paidLottos){
            System.out.println(paidLotto.getNumbers());
        }
    }

    public static void printWinningLottoNumber(){
        System.out.println("\n"+Message.INPUT_LOTTO_NUMBERS_MESSAGE);
    }

    public static void printBonusNumber(){
        System.out.println("\n"+Message.INPUT_BOUNUS_NUMBER_MESSAGE);
    }

    public static void printWinningResult(Map<WinningResult,Integer> winningResultCountMap, int lottoBuyCount){
        printWinningResultHeader();
        for(WinningResult result : WinningResult.values()){
            printWinningResultBody(winningResultCountMap,result);
        }
        printWinningResultRate(winningResultCountMap,lottoBuyCount);
    }

    public static void printWinningResultRate(Map<WinningResult,Integer> winningResultCountMap, int lottoBuyCount){
        double totalPrice = Result.calcProfitRate(winningResultCountMap,lottoBuyCount);
        System.out.println(Message.INFORM_FIRST_LOTTO_RESULT_PROFIT_RATE+String.format("%.1f",totalPrice)
                +Message.INFORM_SECOND_LOTTO_RESULT_PROFIT_RATE);
    }


    //프린트
    public static void printWinningResultHeader(){
        System.out.println("\n"+Message.INFORM_LOTTO_RESULT_HEADER);
    }

    public static void printWinningResultBody(Map<WinningResult,Integer> winningResultCountMap, WinningResult result){
        if(!result.toString().equals(WinningResult.NO_WIN.toString())) {
            if(result.toString().equals(WinningResult.SECOND_WIN.toString())){
                System.out.printf(Message.INFORM_LOTTO_RESULT_BODY_BONUS,result.getNumberCount());
            }else{
                System.out.printf(Message.INFORM_LOTTO_RESULT_BODY_COUNT,result.getNumberCount());
            }
            System.out.printf(Message.INFORM_LOTTO_RESULT_BODY_PRICE,result.getWinningPrice());
            System.out.printf(Message.INFORM_LOTTO_RESULT_BODY_WIN_COUNT+"\n",winningResultCountMap.get(result));
        }
    }

}