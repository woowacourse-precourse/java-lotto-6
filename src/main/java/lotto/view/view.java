package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class view {
    private static final String INPUT_AMOUNT_LOTTO = "구입 금액을 입력해 주세요";
    private static final String INPUT_LOTTO_WINNING_NUMBER = "당첨 번호를 입력해 주세요";
    private static final String INPUT_LOTTO_BONUS_NUMBER = "보너스 번호를 입력해 주세요";


    private static List<Integer> winningNumberList;

    public view(){
    }


    public static String inputAmountLotto(){
        System.out.println(INPUT_AMOUNT_LOTTO);
        return Console.readLine();
    }

    public static void PrintNumberOfLottoTickets(int NumberOfTickets){
        System.out.println(NumberOfTickets+"개를 구매했습니다.");
    }

    public static List<Integer> inputLottoWinningNumber(){
        System.out.println(INPUT_LOTTO_WINNING_NUMBER);
        return numberList(Console.readLine());
    }

    private static List<Integer> numberList(String winningNumber){
        String[] result = winningNumber.split(",");
        winningNumberList = new ArrayList<>();
        for(int i=0; i<result.length; i++){
            winningNumberList.add(conventListToInt(result[i]));
        }
        return winningNumberList;
    }

    private static int conventListToInt(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            ExceptionMessage.errorMessage();
            ExceptionMessage.inputMustNumber();
            throw new IllegalArgumentException();
        }
    }


    public static int inputBounusNumber(){
        System.out.println(INPUT_LOTTO_BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }

    public static void PrintResult(){
        System.out.println("당첨 통계");
        System.out.println("---");

    }

    public static void printNumberOfWinsMessage(String message, int numberOfMatch){
        System.out.println(message + numberOfMatch +"개");
    }

    public static void printEarningRate(double EarningRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", EarningRate) + "%입니다.");
    }
}

