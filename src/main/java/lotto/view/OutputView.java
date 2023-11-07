package lotto.view;



import lotto.domain.Lotto;

import java.util.HashMap;
import java.util.List;

import static lotto.domain.Constant.MAX_LOTTOES_SIZE;
import static lotto.domain.Message.*;


public class OutputView {

    public static void printPurchaseLottoes(List<Lotto> lottoes){
        System.out.println("\n"+lottoes.size()+ OUTPUT_PURCHASE);
        for(Lotto lotto : lottoes){
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printFinalResult(HashMap<Integer, Integer> matchCount, double rateOfReturn){
        System.out.println("\n"+OUTPUT_RESULT_START);
        System.out.println(THREE_MATCH+matchCount.get(3)+COUNT);
        System.out.println(FOUR_MATCH+matchCount.get(4)+COUNT);
        System.out.println(FIVE_MATCH+matchCount.get(5)+COUNT);
        System.out.println(FIVE_BONUS_MATCH+matchCount.get(6)+COUNT);
        System.out.println(SIX_MATCH+matchCount.get(7)+COUNT);
        System.out.println(RATE_OF_RETURN+rateOfReturn+END);
    }






}
