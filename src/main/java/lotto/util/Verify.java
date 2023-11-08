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

    public static List<Integer> inputVerifyToStringArray(String input) throws IllegalArgumentException{
        input.replace(" ","");
        String[] numbers = input.split(",");
        List<Integer> inputList = new ArrayList<>();
        for(int i=0; i<numbers.length; i++){
            Integer number = Integer.parseInt(String.valueOf(numbers[i]));
            if(number<0 || number>46)
                throw new IllegalArgumentException();
            inputList.add(number);
        }
        return inputList;
    }
}
