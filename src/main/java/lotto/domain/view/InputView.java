package lotto.domain.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.exception.ExceptionMessage;

public class InputView {

    public int enterPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return convertToInt(input);
    }

    public List<Integer> enterWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        return convertToIntegerList(input);
    }

    int convertToInt(String input){
        try{
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

}
