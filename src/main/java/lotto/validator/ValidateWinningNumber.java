package lotto.validator;


import lotto.validator.errormessage.ErrorMessage;

import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateWinningNumber {
    static final int START_INCLUSIVE=1;
    static final int END_INCLUSIVE=45;
    public static void validateWinningNumber(String buyerInput){
        validateEmpty(buyerInput);
        validateNumerical(tokenizer(buyerInput));
        validateNumberRange(tokenizer(buyerInput));
        validateSize(tokenizer(buyerInput));
        validateDuplication(tokenizer(buyerInput));
    }

    private static void validateDuplication(StringTokenizer tokenizer) {
        HashSet set=new HashSet();
        while(tokenizer.hasMoreTokens()){
             int number = Integer.parseInt(tokenizer.nextToken());
             if(hasDuplication(set,number)){
                 throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
             }
        }

    }

    private static boolean hasDuplication(HashSet set,int number){
        if(!set.add(number)){
            return true;
        }
        return false;
    }

    private static void validateNumerical(StringTokenizer tokenizer) {
        while(tokenizer.hasMoreTokens()){
            if(!isNumerical(tokenizer)){
                throw new IllegalArgumentException(ErrorMessage.INCORRECT_NUMERICAL_INPUT.getMessage());
            }
        }

    }

    private static boolean isNumerical(StringTokenizer tokenizer) {
        Pattern pattern=Pattern.compile("^[0-9]+$");
        Matcher matcher=pattern.matcher(tokenizer.nextToken());
        return matcher.matches();
    }

    private static StringTokenizer tokenizer(String buyerInput){
        StringTokenizer tokenizer=new StringTokenizer(buyerInput,",");
        return tokenizer;
    }
    private static void validateSize(StringTokenizer tokenizer){
        if(isOutOfSize(tokenizer)){
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_SIZE.getMessage());
        }
    }

    private static boolean isOutOfSize(StringTokenizer tokenizer){
        if(tokenizer.countTokens()>6){
            return true;
        }
        if(tokenizer.countTokens()<6){
            return true;
        }
        return false;
    }

    private static void validateEmpty(String buyerInput) {
        if(buyerInput.isBlank()){
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private static void validateNumberRange(StringTokenizer tokenizer){
        while(tokenizer.hasMoreTokens()){
            int number = Integer.parseInt(tokenizer.nextToken());
            if(isOutOfRange(number))
                throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE.getMessage());
        }
    }
    private static boolean isOutOfRange(int number){
        if(number<START_INCLUSIVE){
            return true;
        }
        if(number>END_INCLUSIVE){
            return true;
        }
        return false;
    }
}
