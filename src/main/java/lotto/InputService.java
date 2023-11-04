package lotto;

import static lotto.settings.ErrorMessage.*;

import camp.nextstep.edu.missionutils.Console;

public class InputService {

    public static Integer purchaseAmount(){
        String s = Console.readLine();
        validateTrim(s);
        validateNumber(s);
        return Integer.parseInt(s);
    }

    private static void validateNumber(String s) {
        try{
            Integer.parseInt(s);
        }catch (Exception e){
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private static void validateTrim(String s) {
        String trim = s.trim();
        if(s.length() != trim.length()){
            throw new IllegalArgumentException(CONTAIN_SPACE.getMessage());
        }
    }
}
