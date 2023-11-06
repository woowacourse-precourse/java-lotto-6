package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    private static final String OUTPUT_LOTTO_AMOUNT = "개를 구매했습니다.";

    private static final String OUTPUT_WINNING_STATISITCS = "당첨 통계";

    public static void outputLottoAmountMessage(int amount){
        System.out.println();
        System.out.println(amount+OUTPUT_LOTTO_AMOUNT);
    }

    public static void outputSortingLottoNumber(List<Integer> number){
        System.out.println(number.toString());
    }

    public static void outputWinningStatisitcs(HashMap<Integer,Integer> hash, double winningRate){
        statisitcsView[] views = statisitcsView.values();
        System.out.println('\n'+OUTPUT_WINNING_STATISITCS);
        System.out.println("---");
        for(int i=3; i<=6; i++){
            System.out.println(views[i-3].getMessage()+hash.get(i)+"개");
            if(i==5){
                System.out.println(views[4].getMessage()+hash.get(i+2)+"개");
            }
        }
        System.out.printf("총 수익률은 %.1f%%입니다.",winningRate);
    }

}
