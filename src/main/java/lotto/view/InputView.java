package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String NUMERIC_ERROR_MESSAGE = ErrorMessage.NUMERIC_ERROR.getMessage();

    public static int inputLottoAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println(NUMERIC_ERROR_MESSAGE);
            return inputLottoAmount();
        }
    }

    public static List<Integer> inputWinningNumber() {
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            String winningNumber = Console.readLine();
            String[] winningNumberStrings = winningNumber.split(",");

            return Arrays.stream(winningNumberStrings)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            System.out.println(NUMERIC_ERROR_MESSAGE);
            return inputWinningNumber();
        }
    }

    public static List<Integer> inputBonusNumber() {
        try {
            List<Integer> bonusNumbers = new ArrayList<>();
            System.out.println("보너스 번호를 입력해 주세요.");
            int bonusNumber = Integer.parseInt(Console.readLine());
            bonusNumbers.add(bonusNumber);
            return bonusNumbers;
        } catch (NumberFormatException e) {
            System.out.println(NUMERIC_ERROR_MESSAGE);
            return inputBonusNumber();
        }
    }
}
