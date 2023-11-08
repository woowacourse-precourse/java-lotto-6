package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static List<Integer>winningNumberList;
    public static String inputLottoAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static List<Integer> inputWinningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();
        return toList(numbers);
    }

    public static int  BonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNum = Console.readLine();
        return toInt(bonusNum);
    }
    public static List<Integer> toList(String winningNumber){
        String [] tmp = winningNumber.split(",");
        winningNumberList = new ArrayList<>();
        for(String s : tmp){
            winningNumberList.add(toInt(s));
        }
        return winningNumberList;
    }
    public static int toInt(String s){
        try{
            return Integer.parseInt(s);
        }
        catch (NumberFormatException e){
            ExceptionMessage.typeException();
            throw new IllegalArgumentException();
        }
    }
}
