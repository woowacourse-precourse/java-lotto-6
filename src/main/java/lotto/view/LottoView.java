package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lottos;
import lotto.parser.FinalResult;
import lotto.view.constant.LottoMessage;

import java.util.List;

import static lotto.view.constant.LottoGradeMessage.*;
import static lotto.view.constant.LottoGradeMessage.SIX_GRADE;
import static lotto.view.constant.LottoMessage.SHOW_STATISTICS_YIELD;
import static lotto.view.constant.LottoMessage.SHOW_STATISTICS_YIELD_SUFFIX;


public class LottoView {
    private static final Integer PERCENT = 100;
    public static void printConstantMessage(LottoMessage lottoMessage){
        System.out.println(lottoMessage.getMessage());
    }
    public static void printVariableMessage(String message){
        System.out.println(message);
    }
    public static String requestInputPrice(){
        printConstantMessage(LottoMessage.REQUEST_PURCHASE_AMOUNT);
        return Console.readLine();
    }
    public static void printResponsePurchaseAmount(int lottoCount){
        printWhiteSpace();
        printVariableMessage(lottoCount + LottoMessage.RESPONSE_PURCHASE_AMOUNT.getMessage());
    }
    public static void printRandomLottos(Lottos randomLottos){
        printVariableMessage(randomLottos.toString());
    }
    public static String requestInputWinningNumbers(){
        printConstantMessage(LottoMessage.REQUEST_WINNING_NUMBER);
        return Console.readLine();
    }
    public static String requestInputBonusNumber(){
        printWhiteSpace();
        printConstantMessage(LottoMessage.REQUEST_BONUS_NUMBER);
        return Console.readLine();
    }
    public static void printResultMessages(){
        printWhiteSpace();
        printConstantMessage(LottoMessage.SHOW_STATISTICS);
        printConstantMessage(LottoMessage.SHOW_STATISTICS_DELIMITER);
    }
    public static void printResultMessage(FinalResult finalResult, int price){
        printResult(finalResult);
        printProfitRate(finalResult,price);
    }
    public static void printResult(FinalResult finalResult) {
        List<Integer> countList = finalResult.lottoResult().lottoMatchNumberDTO().getCountList();
        printVariableMessage(THREE_GRADE.getComment(countList.get(0)));
        printVariableMessage(FOUR_GRADE.getComment(countList.get(1)));
        printVariableMessage(FIVE_GRADE.getComment(countList.get(2)));
        printVariableMessage(FIVE_GRADE_AND_BONUS.getComment(countList.get(3)));
        printVariableMessage(SIX_GRADE.getComment(countList.get(4)));
    }
    public static void printProfitRate(FinalResult finalResult, Integer price) {
        List<Integer> countList = finalResult.lottoResult().lottoMatchNumberDTO().getCountList();
        int sum = countList.get(0) * THREE_GRADE.getPrize()
                + countList.get(1) * FOUR_GRADE.getPrize()
                + countList.get(2) * FIVE_GRADE.getPrize()
                + countList.get(3) * FIVE_GRADE_AND_BONUS.getPrize()
                + countList.get(4) * SIX_GRADE.getPrize();
        printVariableMessage(SHOW_STATISTICS_YIELD.getMessage() + (float)sum / price * PERCENT + SHOW_STATISTICS_YIELD_SUFFIX.getMessage());
    }
    private static void printWhiteSpace() {
        System.out.println();
    }

}
