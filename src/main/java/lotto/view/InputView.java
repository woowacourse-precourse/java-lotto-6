package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String INPUT_LOTTO_AMOUT = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_WINNING = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String INPUT_TYPE_ERROR = "[ERROR] 숫자만 입력해 주세요.";

    private static List<Integer> winningNumberList;

    public static int inputPurchaseAmount(){
        System.out.println(INPUT_LOTTO_AMOUT);
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> inputLottoWinningNumber(){
        System.out.println(INPUT_LOTTO_WINNING);
        return numberList(Console.readLine());
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> numberList(String winningNumber){
        String[] winning = winningNumber.split(",");
        winningNumberList = new ArrayList<>();
        for (String s : winning) {
            winningNumberList.add(convertToInt(s));
        }
        return winningNumberList;
    }

    private static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(INPUT_TYPE_ERROR);
        }
    }


}
