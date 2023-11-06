package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import lotto.View.ExceptionMessage;
import lotto.View.InputView;

public class InputController {
    public static int inputTicketsAmount(){
        InputView.printTicketsAmount();
        try {
            return validateNum(Console.readLine());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputTicketsAmount();
        }
    }
    public static List<Integer> inputWinningNumbers(){
        InputView.printWinningNumbers();
        try {
            return toWinningNumbers(Console.readLine());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputWinningNumbers();
        } catch (NoSuchElementException e){
            throw new IllegalArgumentException(ExceptionMessage.NO_SUCH_ELEMENT);
        }

    }
    public static int inputBonusNumber(){
        InputView.printBonusNumber();
        try {
            return validateNum(Console.readLine());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }  catch (NoSuchElementException e){
            throw new IllegalArgumentException(ExceptionMessage.NO_SUCH_ELEMENT);
        }
    }
    private static List<Integer> toWinningNumbers(String input){
        try{
            String[] strWinningNums = input.split(",");
            List<Integer> winningNumbers = new ArrayList<>();
            for(String s : strWinningNums){
                winningNumbers.add(Integer.parseInt(s.trim()));
            }
            return winningNumbers;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_EMPTY_INPUT);
        }

    }
    private static int validateNum(String input){
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_INPUT_NUMBER);
        }
    }

}
