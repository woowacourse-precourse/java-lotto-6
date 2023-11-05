package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Controller.Validator;

public class inputView {
    static final String GET_INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    static final String GET_INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    static final String GET_INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static int getInputPurchaseAmount() {
        System.out.println(GET_INPUT_PURCHASE_AMOUNT_MESSAGE);

        while (true) {
            String input = Console.readLine();
            try {
                int amount = Validator.validatePurchaseAmount(input);
                return amount;
            } catch (IllegalArgumentException e) {
                input = Console.readLine();
            }
        }
    }

    public static List<Integer> getInputWinningNumber(){
        System.out.println(GET_INPUT_WINNING_NUMBERS_MESSAGE);
        String input = Console.readLine();
        while(true){
            try {
                List<Integer> list = Arrays.stream(input.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                return list;
            } catch (IllegalArgumentException e) {
                input = Console.readLine();
            }
        }
    }

    public static int getInputBonusNumber() {
        System.out.println(GET_INPUT_BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        while(true){
            try {
                int number = Validator.validateBonusNumber(input);
                return number;
            } catch (IllegalArgumentException e) {
                input = Console.readLine();
            }
        }
    }


}
