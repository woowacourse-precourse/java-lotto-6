package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String INPUT_LOTTO_AMOUNT = "구입 금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_WINNING = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String inputPlayerAmount(){
        System.out.println(INPUT_LOTTO_AMOUNT);
        return Console.readLine();
    }
    public static List<Integer> inputLottoWinningNum(){
        System.out.println(INPUT_LOTTO_WINNING);
        return numberList(Console.readLine());
    }
    public static int inputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }
    public static List<Integer>numberList (String winningNumber){
        String[] result = winningNumber.split(",");
        List<Integer> winningNumberList = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            winningNumberList.add(conventToInt(result[i]));
        }
        return winningNumberList;
    }

    private static Integer conventToInt(String inputNumber) {
        try{
            return Integer.parseInt(inputNumber);
        }catch(NumberFormatException e){
            ExceptionMessage.typeEXCEPTIOM();
            throw new IllegalArgumentException();
        }
    }


}

