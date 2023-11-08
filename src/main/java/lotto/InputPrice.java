package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputPrice {
    private static final String InputLottoPrice = "구입금액을 입력해 주세요.";
    private static final String InputWinningNumber = "당첨 번호를 입력해 주세요.";
    private static final String InputBonusNumber="보너스 번호를 입력해 주세요.";
    private static List<Integer>winningNumberList;
    private static final int MinAmount = 1000;

    public static String InputPlayerPrice() {
        System.out.println(InputLottoPrice);
        return Console.readLine();
    }

    public static List<Integer> inputLottoWinningNum(){
        System.out.println(InputWinningNumber);
        return numberList(Console.readLine());
    }

    public static int inputBonusNumber(){
        System.out.println(InputBonusNumber);
        return Integer.parseInt((Console.readLine()));
    }

    public static List<Integer> numberList(String winningNumber) {
        String[] result = winningNumber.split(",");
        winningNumberList = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            winningNumberList.add(conventToInt(result[i]));
        }
        return winningNumberList;
    }

    private static Integer conventToInt(String inputNumber) {
        return Integer.parseInt(inputNumber);

    }


}
