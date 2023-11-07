package lotto.service;

import static lotto.settings.ErrorMessage.CONTAIN_SPACE;
import static lotto.settings.ErrorMessage.HAS_COMMA_ON_BOTH_SIDES;
import static lotto.settings.ErrorMessage.INVALID_NUMBER_FORMAT;

public class Validate {
    public static void number(String input) {
        try{
            stringToInt(input);
        }catch (Exception e){
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    public static void number(String[] inputs) {
        try{
            for (String input : inputs) {
                stringToInt(input);
            }
        }catch (Exception e){
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    public static void trim(String input) {
        String trimInput = input.replaceAll(" ","");
        if(input.length() != trimInput.length()){
            throw new IllegalArgumentException(CONTAIN_SPACE.getMessage());
        }
    }
    public static void commaBeforeAndAfter(String[] input) {
        for (String s : input) {
            if(s.isBlank()){
                throw new IllegalArgumentException(HAS_COMMA_ON_BOTH_SIDES.getMessage());
            }
        }
    }

    public static int stringToInt(String input) {
        return Integer.parseInt(input);
    }
}
