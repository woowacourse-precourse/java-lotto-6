package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String INPUT_LOTTO_AMOUNT = "구입 금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static List<Integer> winningNumbers;

    // 구입 금액 입력
    public static String inputLottoAmount() {
        System.out.println(INPUT_LOTTO_AMOUNT);
        return Console.readLine();
    }

    // 당첨 번호 입력
    public static List<Integer> inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        return numberList(Console.readLine());
    }

    // 보너스 번호 입력
    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }

    // 입력한 당첨 번호를 ","로 구분해서 리스트로 변환
    public static List<Integer> numberList(String winningNum) {
        String[] res = winningNum.split(",");
        winningNumbers = new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
            winningNumbers.add(convertToInt(res[i]));
        }
        return winningNumbers;
    }

    public static int convertToInt(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            ExceptionMessage.inputTypeException();
            throw new IllegalArgumentException();
        }
    }
}
