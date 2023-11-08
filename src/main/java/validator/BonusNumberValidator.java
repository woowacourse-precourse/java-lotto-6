package validator;

import constant.ConfigNumber;
import constant.ErrorMessage;

import java.util.List;

public class BonusNumberValidator {
    public static void validDuplicate(List<Integer> nums, int number){
        if(nums.contains(number))
            new IllegalArgumentException(ErrorMessage.MESSAGE + " " + ErrorMessage.DUPLICATE_MESSAGE);
    }

    public static int validNumberic(String data){
        try{
            return Integer.parseInt(data);
        }catch (IllegalArgumentException e){
            throw new NumberFormatException(ErrorMessage.MESSAGE + " " + ErrorMessage.NUMBERIC_MESSAGE);
        }
    }
    public static void validRange(int number){
        if(!(number >= ConfigNumber.START_INCLUSIVE.getValue() && number<= ConfigNumber.END_INCLUSIVE.getValue()))
            throw new IllegalArgumentException(ErrorMessage.MESSAGE + " " + ErrorMessage.RANGE_MESSAGE);
    }
}
