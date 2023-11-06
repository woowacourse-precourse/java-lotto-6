package lotto.InputView;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.exception.ExceptionMessage;

public class InputView {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BONUS_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String LOTTO_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static List<Integer> winningNumberList;

    public String getAmount() {
        System.out.println(MONEY_INPUT_MESSAGE);
        return Console.readLine();
    }

    public int getBonusNumber() {
        System.out.println(BONUS_INPUT_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> getLottoNumber() {
        System.out.println(LOTTO_NUMBER_INPUT_MESSAGE);
        return numberList(Console.readLine());
    }

    public static List<Integer> numberList(String winningNumber) {
        String[] result = winningNumber.split(",");
        winningNumberList = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            winningNumberList.add(conventToInt(result[i]));
        }
        return winningNumberList;
    }

    private static int conventToInt(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            ExceptionMessage.typeException();
            throw new IllegalArgumentException();
        }
    }
}
