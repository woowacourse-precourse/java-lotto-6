package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class Verify {

    public Verify(){}
    public static Integer verifyAmount(String input) throws IllegalArgumentException{
        Integer value = Integer.parseInt(String.valueOf(input));
        if(value < 1000)
            throw new IllegalArgumentException();
        return value;
    }

    public static List<Integer> verifyWinningNumbersStringToList(String input) throws IllegalArgumentException{
        input = input.replace(" ","");
        String[] numbers = input.split(",");
        List<Integer> inputList = new ArrayList<>();
        for(int i=0; i<numbers.length; i++){
            Integer number;
            try{
                number = Integer.parseInt(String.valueOf(numbers[i]));
            }
            catch (NumberFormatException e){
                throw new IllegalArgumentException();
            }
            if(number<0 || number>46)
                throw new IllegalArgumentException();
            inputList.add(number);
        }
        return inputList;
    }

    public static Integer verifyBonusNumber(String input) throws IllegalArgumentException{
        input = input.replace(" ","");
        Integer number;
        try{
            number = Integer.parseInt(String.valueOf(input));
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
        if(number<0 || number>46)
            throw new IllegalArgumentException();
        return number;
    }
}
