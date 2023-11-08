package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import static util.NumberValidator.*;
import static view.ViewException.*;

public class InputView {
    public final String comma = ",";
    public String inputFromUser(){
        return Console.readLine();
    }

    public String[] inputCommaSplitor(String input){
        if(!input.contains(comma)){
            throw new IllegalArgumentException(INPUT_MUST_CONTAINS_COMMA_SEP.getMessage());
        }
        return input.split(comma);
    }

    public int inputMoneyFromUser(){
        String inputMoney = inputFromUser();
        canParseToMoney(toLong(inputMoney));
        return toInt(inputMoney);
    }

    public Long toLong(String input){
        if(!canParseToLong(input)){
            throw new IllegalArgumentException(INPUT_SHOULD_BE_NUMBER.getMessage());
        }
        return Long.parseLong(input);
    }

    public List<Integer> inputLottoWinnerNumberFromUser(){
        List<Integer> numbers = new ArrayList<>();
        String[] userInput = inputCommaSplitor(inputFromUser());
        for(String inputElement : userInput){
            int number = toInt(inputElement);
            numbers.add(number);
        }
        isInRange(numbers);
        isDistinct(numbers);
        isSuitableLength(numbers);
        return numbers;
    }

    public int inputBonusNumberFromUser(List<Integer> winNumber){
        int number = toInt(inputFromUser());
        canGenerateBonusNumber(winNumber, number);
        return number;
    }

    public int toInt(String input){
        if(!isNumeric(input)){
            throw new IllegalArgumentException(INPUT_SHOULD_BE_NUMBER.getMessage());
        }
        return Integer.parseInt(input);
    }
}
