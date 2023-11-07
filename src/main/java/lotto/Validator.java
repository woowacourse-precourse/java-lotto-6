package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {
    protected int validateStringIsInt(String subjectString) throws IllegalArgumentException{
        int validatedInt;
        try{
            validatedInt = Integer.parseInt(subjectString);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
        return validatedInt;
    }
    protected List<Integer> validateStringIsIntegers(String subjectString) throws IllegalArgumentException{
        List<String> stringList = Arrays.asList(subjectString);
        List<Integer> validatedIntegerList = new ArrayList<>();
        for (String string : stringList) {
            validatedIntegerList.add(validateStringIsInt(string));
        }
        return validatedIntegerList;
    }
}
