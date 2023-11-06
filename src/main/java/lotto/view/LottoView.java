package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lottos;
import lotto.view.constant.LottoMessage;


public class LottoView {
    public static void printConstantMessage(LottoMessage lottoMessage){
        System.out.println(lottoMessage.getMessage());
    }
    public static String requestInputPrice(){
        printConstantMessage(LottoMessage.REQUEST_PURCHASE_AMOUNT);
        return Console.readLine();
    }
    public static void printResponsePurchaseAmount(int lottoCount){
        printWhiteSpace();
        System.out.println(lottoCount + LottoMessage.RESPONSE_PURCHASE_AMOUNT.getMessage());
    }
    public static void printRandomLottos(Lottos randomLottos){
        System.out.println(randomLottos.toString());
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
    public static void responseResultMessages(){
        printWhiteSpace();
        printConstantMessage(LottoMessage.SHOW_STATISTICS);
        printConstantMessage(LottoMessage.SHOW_STATISTICS_DELIMITER);
    }
    private static void printWhiteSpace() {
        System.out.println();
    }

}
