package lotto.validator;


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
        validateDuplication(tokenizer(buyerInput));
    }

    private static void validateDuplication(StringTokenizer tokenizer) {
        HashSet set=new HashSet();
        while(tokenizer.hasMoreTokens()){
             int number = Integer.parseInt(tokenizer.nextToken());
             if(hasDuplication(set,number)){
                 throw new IllegalArgumentException("[ERROR] 증복된 숫자는 입력할 수 없습니다.");
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
                throw new IllegalArgumentException("[ERROR] 입력값으로 올바른 숫자를 입력하십시오.");
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

    private static void validateEmpty(String buyerInput) {
        if(buyerInput.isBlank()){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력헤주세요.");
        }
    }

    private static void validateNumberRange(StringTokenizer tokenizer){
        while(tokenizer.hasMoreTokens()){
            int number = Integer.parseInt(tokenizer.nextToken());
            if(isOutOfRange(number))
                throw new IllegalArgumentException("[ERROR] 숫자의 범위는 1~45 입니다.");
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
