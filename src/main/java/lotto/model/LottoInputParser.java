package lotto.model;

import lotto.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class LottoInputParser {

    public static List<Integer> notNumber(String userInput){
        String[] inputs = userInput.split(",");
        List<Integer> numbers = new ArrayList<>();
        for(String input : inputs){
            numbers.add(stringToNumber(input));
        }
        return numbers;
    }

    private static int stringToNumber(String input){
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_WINNING_NUMBER);
        }
    }

}
