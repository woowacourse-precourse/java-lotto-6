package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
//TODO : 각 메서드에 대한 예외 처리 및 재입력 구현
public class InputVIew {
    private static final String INPUT_TICKETS_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    //TODO : 중복잡기 , 6개가 넘어가면 예외가 발생
    public static int inputTicketsAmount(){
        System.out.println(INPUT_TICKETS_AMOUNT);
        try {
            return validateNum(Console.readLine());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputTicketsAmount();
        }
    }
    public static List<Integer> inputWinningNumbers(){
        System.out.println(INPUT_WINNING_NUMBERS);
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
        System.out.println(INPUT_BONUS_NUMBER);
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
