package lotto;

import java.util.regex.Pattern;

public class Validator {
    public static int validatePrice(String inputstr){
        if (!Pattern.compile("^[\\d]*$").matcher(inputstr).matches()) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요");
        }
        int parsedstr = Integer.parseInt(inputstr);
        if (parsedstr % 1000 > 0) {
            throw new IllegalArgumentException("[ERROR] 구매 가격은 1000원 단위입니다.");
        }
        return parsedstr;
    }
    public static int validateBonus(String inputstr){
        try{
            int bonus = Integer.parseInt(inputstr);
            if(bonus > 45 || bonus < 1){
                throw new IllegalArgumentException(ErrorMessage.BONUS_NON_RANGE);
            }
            return bonus;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.NON_NUMBER);
        }
    }
}
