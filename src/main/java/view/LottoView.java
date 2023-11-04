package view;

import camp.nextstep.edu.missionutils.Console;
import domain.Lottos;
import view.constant.ConstantMessage;

public class LottoView {
    // InputView
    public static void printAskInputMoney(){
        printlnConstantMessage(ConstantMessage.ASK_MONEY);
    }
    public static void printAskInputWinningNumber(){
        printlnConstantMessage(ConstantMessage.ASK_WINNING_NUMBER);
    }
    public static void printAskInputBonusNumber(){
        printlnConstantMessage(ConstantMessage.ASK_BONUS_NUMBER);
    }

    // OutputView
    public static void printBuyResult(int number){
        printNewLine();
        System.out.print(number);
        printlnConstantMessage(ConstantMessage.BUY_RESULT);
    }
    public static void printLottoList(Lottos lottos){
        for(int i=0; i<lottos.getLottos().size(); i++){
            System.out.println(lottos.getLottos().get(i).getNumbers());
        }
        printNewLine();
    }
    public static void printWinningResult(){
        printlnConstantMessage(ConstantMessage.WINNING_RESULT);
        printlnConstantMessage(ConstantMessage.THREE_DASH);
        // 당첨 통계 출력 (미구현)
    }
    public static void printTotalReturn(double totalReturn){
        printConstantMessage(ConstantMessage.TOTAL_RETURN);
        System.out.print(" "+totalReturn);
        printlnConstantMessage(ConstantMessage.IPNIDA);
    }

    private static void printConstantMessage(ConstantMessage constantMessage){
        System.out.printf(constantMessage.getMessage());
    }

    private static void printlnConstantMessage(ConstantMessage constantMessage){
        System.out.println(constantMessage.getMessage());
    }
    public static void printException(String message) {
        System.out.println(message);
    }
    private static void printNewLine(){
        System.out.println();
    }
}
