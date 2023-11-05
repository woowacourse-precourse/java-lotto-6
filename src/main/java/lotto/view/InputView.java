package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.message.ExceptionMessage;

public class InputView {
    public int inputAmount(){
        try {
            String input = Console.readLine();

            return Integer.parseInt(input);
        }catch (NumberFormatException e) {
            System.out.println(ExceptionMessage.INVALID_AMOUNT_TYPE.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> inputPrizeNumber(){
        try {
            String input = Console.readLine();
            String[] numbersStr = input.split(",");
            List<Integer> winningNumber = new ArrayList<>();
            for (String numberStr : numbersStr) {
                winningNumber.add(Integer.parseInt(numberStr.trim())); // trim()은 공백을 제거합니다.
            }

            return winningNumber;
        }catch (NumberFormatException e) {
            System.out.println(ExceptionMessage.INVALID_WINNING_TYPE.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public int inputBonusNumber(){
        try {
            String input = Console.readLine();

            return Integer.parseInt(input);
        }catch (NumberFormatException e) {
            System.out.println(ExceptionMessage.INVALID_BONUS_TYPE.getMessage());
            throw new IllegalArgumentException();
        }
    }
}
