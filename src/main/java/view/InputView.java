package view;

import static util.ErrorMessage.ONLY_CAN_NUMBER;
import static util.ProgressMessage.INPUT_AMOUNT;
import static util.ProgressMessage.INPUT_BONUS_NUMBER;
import static util.ProgressMessage.INPUT_WINNING_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static int inputLottoPurchaseAmount() {
        System.out.println(INPUT_AMOUNT.getProgressMessage());
        String amount = getInput();

        if(validateNotNumber(amount)){
            return inputLottoPurchaseAmount();
        }
        return Integer.parseInt(amount);
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.getProgressMessage());
        String bonus = getInput();

        if(validateNotNumber(bonus)){
            return inputBonusNumber();
        }
        return Integer.parseInt(bonus);
    }

    private static boolean validateNotNumber(String input){
        try {
            Integer.parseInt(input);
        }catch(IllegalArgumentException e) {
            System.out.println(ONLY_CAN_NUMBER.getErrorMessage());
            return true;
        }
        return false;
    }

    public static List<Integer> inputWinningLottoNumber() {
        System.out.println(INPUT_WINNING_LOTTO_NUMBER.getProgressMessage());
        return validateIsLotto();
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
