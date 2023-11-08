package lotto.view;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    private static final String OUTPUT_LOTTO_AMOUNT = "를 구매했습니다.";
    private static final String OUTPUT_WINNING_STATISITCS = "당첨 통계";

    private static final String BAR = "---";
    private static final String AMOUNT = "개";

    public static void outputLottoAmountMessage(int amount){
        System.out.println();
        System.out.println(amount+AMOUNT+OUTPUT_LOTTO_AMOUNT);
    }
    public static void outputSortingLottoNumber(List<Integer> number){
        System.out.println(number.toString());
    }

    public static void outputWinningStatisitcs(HashMap<Integer,Integer> hash, double winningRate){
        System.out.println('\n'+OUTPUT_WINNING_STATISITCS);
        System.out.println(BAR);
        for(int i=1; i<=5; i++){
            System.out.println(StatisitcsView.getStatistics(i)+hash.get(i)+AMOUNT);
        }
        System.out.printf("총 수익률은 %.1f%%입니다.",winningRate);
    }

}
