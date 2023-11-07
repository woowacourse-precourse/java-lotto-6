package validator;

import constant.ErrorMessage;
import constant.LottoConfig;
import view.Output;

import java.io.EOFException;

public class LottoMoneyValidator {

    public static void validate(String input){
        validNumberic(input);
        validFitLottoCost(input);
    }

    public static void validNumberic(String data){
       try{
           Integer.parseInt(data);
       }catch (IllegalArgumentException e){
           throw new NumberFormatException(ErrorMessage.MESSAGE + " " + ErrorMessage.NUMBERIC_MESSAGE);
       }
    }

    public static void validFitLottoCost(String data){
        if(Integer.parseInt(data) % LottoConfig.COST.getValue() != 0){
            throw new IllegalArgumentException(ErrorMessage.MESSAGE + " " + ErrorMessage.FIT_LOTTO_COST);
        }
    }
}
