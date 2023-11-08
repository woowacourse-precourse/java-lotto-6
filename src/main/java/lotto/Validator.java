package lotto;

import lotto.Exceptions.DupeNumbersException;
import lotto.Exceptions.NumberNotInRangeException;

import java.util.*;

public class Validator {
    protected int validateStringIsInt(String subjectString) throws NumberFormatException{
        int validatedInt;
        validatedInt = Integer.parseInt(subjectString);
        return validatedInt;
    }
    protected List<Integer> validateStringIsIntegers(String subjectString) throws NumberFormatException{
        List<String> stringList = new ArrayList<>(Arrays.asList(subjectString.split(",")));
        List<Integer> validatedIntegerList = new ArrayList<>();
        for (String string : stringList) {
            validatedIntegerList.add(validateStringIsInt(string));
        }
        return validatedIntegerList;
    }
    protected void validateNumbersInRange(List<Integer> subjectNumbers, int min, int max) throws NumberNotInRangeException{
        for (int subjectNumber : subjectNumbers){
            if (subjectNumber < min || subjectNumber > max){
                throw new NumberNotInRangeException();
            }
        }
    }
    protected void validateNumbersDupeCheck(List<Integer> subjectNumbers) throws DupeNumbersException{
        Set<Integer> setNumbers = new HashSet<>(subjectNumbers);
        if (setNumbers.size() != subjectNumbers.size()){
            throw new DupeNumbersException();
        }
    }
}
