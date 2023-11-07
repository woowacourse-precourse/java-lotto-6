package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String INPUT_LOTTO_PRICE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_WINNING = "당첨 번호를 입력해 주세요.";

    private static List<Integer> winningNumbers;

    public static String inputPlayerLottoPrice() {
        System.out.println(INPUT_LOTTO_PRICE);
        return Console.readLine();
    }

    public static List<Integer> inputLottoWinNumber() {
        System.out.println(INPUT_LOTTO_WINNING);
        return getWinningNumbers(Console.readLine());
    }

    public static List<Integer> getWinningNumbers(String winningNumber) {
        String[] numbers = winningNumber.split(",");
        winningNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            winningNumbers.add(Integer.parseInt(numbers[i]));
        }
        return winningNumbers;
    }
}
