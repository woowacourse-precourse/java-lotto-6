package view;

import static util.ErrorMessage.ONLY_CAN_NUMBER;
import static util.ProgressMessage.INPUT_AMOUNT;
import static util.ProgressMessage.INPUT_WINNING_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import domain.Amount;
import domain.Lotto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static Amount inputLottoPurchaseAmount() {
        System.out.println(INPUT_AMOUNT.getProgressMessage());
        return new Amount(validateIsNumber());
    }

    private static int validateIsNumber(){
        while(true) {
            int amount = 0;
            try {
                amount = Integer.parseInt(getInput());
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(ONLY_CAN_NUMBER.getErrorMessage());
            }
        }
    }

    public static Lotto inputWinningLottoNumber() {
        System.out.println(INPUT_WINNING_LOTTO_NUMBER.getProgressMessage());
        return new Lotto(validateIsLotto());
    }

    private static List<Integer> validateIsLotto(){
        while(true) {
            List<Integer> winningNumbers = new ArrayList<>();
            try {
                List<String> input = Arrays.stream(getInput().split(","))
                        .toList();
                input.forEach(winningnumber -> {
                    winningNumbers.add(Integer.parseInt(winningnumber));
                });
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(ONLY_CAN_NUMBER.getErrorMessage());
            }
        }
    }

    private static String getInput() {
        return Console.readLine();
    }

}
