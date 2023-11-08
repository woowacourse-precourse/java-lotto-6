package lotto.util;

import java.util.regex.Pattern;

import static lotto.io.ErrorMessage.VALUE_NOT_INTEGER;

public class StringConverter {

    private StringConverter(){
    }

    public static long toLong(String data){
        data = data.trim();
        if(!Pattern.matches("\\d+",data)){
            throw new IllegalArgumentException(VALUE_NOT_INTEGER.getMessage());
        }

        return Long.parseLong(data);
    }

}
