package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.utils.ErrorMessage;

public class InputView {

    private InputView() {
    }

    public static String userInput() {
        return Console.readLine();
    }

    public static int userInputParsedInt(String input) {
        return Integer.parseInt(input);
    }

    public static int inputUserPrice() {
        try{
            try {
                String input = userInput();
                return userInputParsedInt(input);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.USER_INSERT_ONLY_NUMBER.getMessage());
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputUserPrice();
        }
    }


    public static List<Integer> inputLottoNumbers() {
        String input = InputView.userInput();
        List<Integer> numbers = new ArrayList<>();
        for (String s : input.split(",")) {
            try {
                int num = Integer.parseInt(s);
                numbers.add(num);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.USER_INSERT_ONLY_NUMBER.getMessage());
            }
        }
        return numbers;
    }

    public static int inputBonusNumber() {
        String input = InputView.userInput();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.USER_INSERT_ONLY_NUMBER.getMessage());
        }
    }
}
