package lotto.util.convert;

import lotto.util.validate.CommonValidate;

public class ConvertUtil {

    public static int stringToInt(String input){
        try{
            CommonValidate.checkBlank(input);
            CommonValidate.checkIsNumber(input);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e);
        }
        return Integer.parseInt(input);
    }
}
