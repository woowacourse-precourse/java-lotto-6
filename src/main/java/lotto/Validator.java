package lotto;

public class Validator {
    public static int validatePrice(String inputstr){
        try{
            int parsedstr = Integer.parseInt(inputstr);
            if(parsedstr % 1000 > 0) throw new IllegalArgumentException(ErrorMessage.NON_1000_DIVIDABLE);
            return parsedstr;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.NON_NUMBER);
        }
    }
    public static int validateBonus(String inputstr){
        try{
            int bonus = Integer.parseInt(inputstr);
            if(bonus > 45 || bonus < 1) throw new IllegalArgumentException(ErrorMessage.BONUS_NON_RANGE);
            return bonus;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.NON_NUMBER);
        }
    }
}
