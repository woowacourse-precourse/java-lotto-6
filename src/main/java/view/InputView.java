package view;

import static message.ErrorMessage.ONLY_CAN_NUMBER;
import static message.ProgressMessage.INPUT_AMOUNT;
import static message.ProgressMessage.INPUT_BONUS_NUMBER;
import static message.ProgressMessage.INPUT_WINNING_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private InputView() {
    }

    private static String getInput() {
        return Console.readLine();
    }

    public static int inputLottoPurchaseAmount() {
        System.out.println(INPUT_AMOUNT.getProgressMessage());
        String amount = getInput();

        if (validateNotNumber(amount)) {
            return inputLottoPurchaseAmount();
        }
        return Integer.parseInt(amount);
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.getProgressMessage());
        String bonus = getInput();

        if (validateNotNumber(bonus)) {
            return inputBonusNumber();
        }
        return Integer.parseInt(bonus);
    }

    public static List<Integer> inputWinningLottoNumber() {
        System.out.println(INPUT_WINNING_LOTTO_NUMBER.getProgressMessage());
        List<String> input = Arrays.stream(getInput().split(","))
                .toList();

        if (validateNotLotto(input)) {
            return inputWinningLottoNumber();
        }

        List<Integer> winningLotto = new ArrayList<>();
        input.forEach(lottoNumber -> winningLotto.add(Integer.parseInt(lottoNumber)));

        return winningLotto;
    }

    private static boolean validateNotNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ONLY_CAN_NUMBER.getErrorMessage());
            return true;
        }
        return false;
    }

    private static boolean validateNotLotto(List<String> winningLotto) {
        try {
            winningLotto.forEach(Integer::parseInt);
        } catch (IllegalArgumentException e) {
            System.out.println(ONLY_CAN_NUMBER.getErrorMessage());
            return true;
        }
        return false;
    }

}
