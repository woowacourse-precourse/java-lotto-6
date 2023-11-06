package lotto.utils;

import lotto.core.Lotto;

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
    public static void printFifthPlace(int count){
        System.out.println(FIFTH_PLACE_MESSAGE + count + PLACE_MESSAGE_FOOTER);
    }
    public static void printFourthPlace(int count){
        System.out.println(FOURTH_PLACE_MESSAGE + count + PLACE_MESSAGE_FOOTER);
    }
    public static void printThirdPlace(int count){
        System.out.println(THIRD_PLACE_MESSAGE + count + PLACE_MESSAGE_FOOTER);
    }
    public static void printSecondPlace(int count){
        System.out.println(SECOND_PLACE_MESSAGE + count + PLACE_MESSAGE_FOOTER);
    }
    public static void printFirstPlace(int count){
        System.out.println(FIRST_PLACE_MESSAGE + count + PLACE_MESSAGE_FOOTER);
    }
    public static void printProfit(double profit){
        System.out.println(PROFIT_MESSAGE_HEADER + profit + PROFIT_MESSAGE_FOOTER );
    }
}
