package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.exception.ExceptionMessage;

public class InputView {

    public int enterPurchaseAmount(){
        String input = commonReadLine(InputMessage.PURCHASE_AMOUNT);
        return convertToInt(input);
    }

    public int enterBonusNumber(){
        String input = commonReadLine(InputMessage.BONUS_NUMBER);
        return convertToInt(input);
    }
    public List<Integer> enterWinningNumber(){
        String input = commonReadLine(InputMessage.WINNING_NUMBER);

        isCommaValidate(input);
        return convertToIntegerList(input);
    }

    void isCommaValidate(String input){
        if(!isCommaSeparatedNumbers(input)){
            ExceptionMessage.INPUT_NOT_SEPARATED_COMMA.throwException();
        }
    }

    void isEmptyValidate(String input) {
        if(input.isEmpty()){
            ExceptionMessage.INPUT_EMPTY.throwException();
        }
    }

    int convertToInt(String input){
        try{
            input = input.trim();
            return Integer.parseInt(input);
        }catch (NumberFormatException e){
            ExceptionMessage.INPUT_NOT_NUMBER.throwException();
        }
        return 0;
    }

    List<Integer> convertToIntegerList(String input){
        List<Integer> numbers = new ArrayList<>();
        String[] inputs = input.split(",");

        for(String inputNumber: inputs){
            numbers.add(convertToInt(inputNumber));
        }
        return numbers;
    }

    private boolean isCommaSeparatedNumbers(String input) {
        String pattern = "^(\\d+\\s*,\\s*)*\\d+$";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);
        return matcher.matches();
    }

    private String commonReadLine(InputMessage inputMessage){
        System.out.println(inputMessage.getMessage());
        String input = Console.readLine();

        isEmptyValidate(input);
        return input;
    }

}
