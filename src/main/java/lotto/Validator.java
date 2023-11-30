package lotto;

import java.util.NoSuchElementException;
import java.util.regex.Pattern;

public class Validator {
    public static int validatePrice(String inputstr){
        if (!Pattern.compile("^[\\d]*$").matcher(inputstr).matches()) {
            System.out.println(ErrorMessage.NON_NUMBER);
            throw new NoSuchElementException();
        }
        int parsedstr = Integer.parseInt(inputstr);
        if (parsedstr % 1000 > 0) {
            System.out.println(ErrorMessage.NON_1000_DIVIDABLE);
            throw new IllegalArgumentException();
        }
        return parsedstr;
    }
    public static int validateBonus(String inputstr){
        try{
            int bonus = Integer.parseInt(inputstr);
            if(bonus > 45 || bonus < 1){
                System.out.println(ErrorMessage.BONUS_NON_RANGE);
                throw new IllegalArgumentException();
            }
            return bonus;
        }catch(NumberFormatException e){
            System.out.println(ErrorMessage.NON_NUMBER);
            throw new IllegalArgumentException();
        }
    }
}
