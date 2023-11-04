package lotto;

import static lotto.settings.ErrorMessage.*;

import camp.nextstep.edu.missionutils.Console;

public class InputService {

    public static Integer purchaseAmount(){
        String input = readLine();
        validateTrim(input);
        validateNumber(input);
        return Integer.parseInt(input);
    }

    private static void validateNumber(String input) {
        try{
            Integer.parseInt(input);
        }catch (Exception e){
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private static void validateTrim(String input) {
        String trimInput = input.trim();
        if(input.length() != trimInput.length()){
            throw new IllegalArgumentException(CONTAIN_SPACE.getMessage());
        }
    }

    private static String readLine(){
        return Console.readLine();
    }
}
