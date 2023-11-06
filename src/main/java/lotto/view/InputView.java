package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_WINNING = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";


    public static String inputPlayerAmount() {
        System.out.println(INPUT_LOTTO_AMOUNT);
        return Console.readLine();
    }

    public static List<Integer> inputLottoWinningNum() {
        System.out.println(INPUT_LOTTO_WINNING);
        return numberList(Console.readLine());
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> numberList(String winningNumber) {
        String[] result = winningNumber.split(",");
        try {
            return Arrays.stream(result).map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            ErrorMessage.typeException();
            return numberList(Console.readLine());
        }
    }
}