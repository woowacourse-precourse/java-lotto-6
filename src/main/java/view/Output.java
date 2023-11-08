package view;

import static constant.ConfigMessage.*;

import java.util.HashMap;
import constant.ErrorMessage;
import constant.Rank;
import constant.UserRequestMessage;
import constant.UserResponeMessage;
import domain.Lotto;




public class Output {

    /* request message */
    public static void printPurchaseCostRequestMessage(){
        System.out.println(UserRequestMessage.PURCHASE_COST_REQUEST_MESSAGE);
    }

    public static void printWinningNumberRequestMessage(){
        System.out.println(UserRequestMessage.WINNING_NUMBER_REQUEST_MESSAGE);
    }

    public static void printBonusNumberRequestMessage(){
        System.out.println(UserRequestMessage.BONUS_NUMBER_REQUEST_MESSAGE);
    }

    /* respone message */
    public static void printLottoPurchaseMessage(int count){
        System.out.println(String.format("%d%s", count, UserResponeMessage.PURCHASE_MESSAGE));
    }

    public static void printWinningStatisticMessage(){
        System.out.println(UserResponeMessage.WINNING_STATISTIC_MESSAGE);
        System.out.println("---");
    }


    public static void printErrorNullMessage(){
        System.out.println(ErrorMessage.NULL_MESSAGE);
    }

    public static void printErrorNumbericMessage(){
        System.out.println(ErrorMessage.NUMBERIC_MESSAGE);
    }

    public static void printErrorFitLottoCostMessage(){
        System.out.println(ErrorMessage.FIT_LOTTO_COST_MESSAGE);
    }

    public static void printLotto(Lotto lotto){
        System.out.println(lotto);
    }
    public static void errorMessage(Exception error) {
        System.out.println(error.getMessage());
    }

    public static void print(){
        System.out.println();
    }

    public static void printStatistics(HashMap<Rank, Integer> rankCounts) {
        System.out.printf((FIFTH_MATCH.getValue()) + "%n", rankCounts.get(Rank.FIFTH));
        System.out.printf((FOURTH_MATCH.getValue()) + "%n", rankCounts.get(Rank.FOURTH));
        System.out.printf((THIRD_MATCH.getValue()) + "%n", rankCounts.get(Rank.THIRD));
        System.out.printf((SECOND_MATCH.getValue()) + "%n", rankCounts.get(Rank.SECOND));
        System.out.printf((FIRST_MATCH.getValue()) + "%n", rankCounts.get(Rank.FIRST));
    }
}
