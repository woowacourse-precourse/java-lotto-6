package validator;

import enums.Constants;
import java.util.regex.Pattern;


public class InputDataValidator {

    public void validLottoCostInput(String data){
        isNull(data);
        isNumeric(data);
        isDivideBy1000(data);
    }

    public void isNull(String data){
        if (data == null){
            throw new NullPointerException();
        }
    }

    public void isNumeric(String data){
        if (!Pattern.matches(Constants.NUMERIC_REGEX.getConst(), data)){
            throw new IllegalArgumentException();
        }
    }
    public void isDivideBy1000(String data){
        if(Integer.parseInt(data) % 1000 != 0){
            throw new IllegalArgumentException();
        }
    }
}
