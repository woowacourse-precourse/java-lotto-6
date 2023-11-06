package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String INPUT_LOTTO_BUY = "구입 금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_WINNING = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_LOTTO_BONUS = "\n보너스 번호를 입력해 주세요.";

    public static Integer inputBuyMoney(){
        System.out.println(INPUT_LOTTO_BUY);
        String buyMoney = Console.readLine();
        return converToInt(buyMoney);
    }

    public static List<Integer> inputLottoWinning(){
        System.out.println(INPUT_LOTTO_WINNING);
        String winningString = Console.readLine();

        return generateNumberList(winningString);
    }

    public static int inputLottoBonus(){
        System.out.println(INPUT_LOTTO_BONUS);
        String bonusString = Console.readLine();
        return converToInt(bonusString);
    }

    public static List<Integer> generateNumberList(String winningString){
        String[] result = winningString.split(",");
        List<Integer> winning = new ArrayList<>();

        for (int i = 0; i < result.length; i++) {
            winning.add(converToInt(result[i]));
        }
        return winning;
    }

    private static int converToInt(String numString){
        try{
            return Integer.parseInt(numString);
        } catch (NumberFormatException e){
            ExceptionMessage.typeException();
            throw new IllegalArgumentException();
        }
    }
}
