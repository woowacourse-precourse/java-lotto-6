package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String INPUT_LOTTO_PRICE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨번호를 입력해 주세요(쉼표로구분)";
    private static final String INPUT_BONUS_NUMBER = "보너스번호를 입력해 주세요";

    private static List<Integer> winningNumberList;

    public static String inputPlayerPrice() {
        System.out.println(INPUT_LOTTO_PRICE);
        return Console.readLine();
    }

    public static List<Integer> inputLottoNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        return numberToList(Console.readLine());
    }

    private static List<Integer> numberToList(String winningNumber) {
        String[] split = winningNumber.split(",");
        winningNumberList = new ArrayList<>();
        for (String s : split) {
            winningNumberList.add(Integer.parseInt(s));
        }
        return winningNumberList;
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }
}
