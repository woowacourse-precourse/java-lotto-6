package lotto.utils;

import lotto.core.Lotto;
import lotto.core.Prize;

import static lotto.constValue.ConstMessage.*;

public class PrintUtil {
    public static void printPricePrompt(){
        System.out.println(PRICE_PROMPT_MESSAGE);
    }

    public static void printWinningNumberPrompt(){
        System.out.println(WINNING_NUMBER_PROMPT_MESSAGE);
    }

    public static void printBonusNumberPrompt(){
        System.out.println(BONUS_NUMBER_PROMPT_MESSAGE);
    }

    public static void printLottoCount(int lottoCount){
        System.out.println(lottoCount + LOTTO_COUNT_MESSAGE);
    }

    public static void printLottoNumbers(Lotto lotto){
        System.out.println(lotto.getNumbers());
    }

    public static void printTotalWinningResult(){
        System.out.println(TOTAL_WINNING_RESULT_MESSAGE);
        System.out.println("---");
    }

    public static void printPlace(String place){
        System.out.println(place);
    }

    public static void printProfit(String profit){
        System.out.println(PROFIT_MESSAGE_HEADER + profit + PROFIT_MESSAGE_FOOTER );
    }
}
