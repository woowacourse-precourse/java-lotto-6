package validator;

import constant.ErrorMessage;
import constant.ConfigNumber;

public class LottoMoneyValidator {


    public static void validNumberic(String data){
       try{
           Integer.parseInt(data);
       }catch (IllegalArgumentException e){
           throw new NumberFormatException(ErrorMessage.MESSAGE + " " + ErrorMessage.NUMBERIC_MESSAGE);
       }
    }

    public static void validFitLottoCost(String data){
        if(Integer.parseInt(data) % ConfigNumber.COST.getValue() != 0){
            throw new IllegalArgumentException(ErrorMessage.MESSAGE + " " + ErrorMessage.FIT_LOTTO_COST_MESSAGE);
        }
    }

    public static void validNotZero(String data){
        if(Integer.parseInt(data) == 0){
            throw new IllegalArgumentException(ErrorMessage.MESSAGE + " " + ErrorMessage.FIT_LOTTO_COST_MESSAGE);

        }
    }
}
