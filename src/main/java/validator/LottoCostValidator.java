package validator;

import dto.RottoCostRequst;
import view.Output;

public class LottoCostValidator {
    public static final int LOTTO_COST = 1000;
    public boolean validate(String input){
        if(!validNumberic(input))
            return false;
        if(!validFitLottoCost(input))
            return false;

        return true;
    }

    public boolean validNumberic(String data){
       try{
           Integer.parseInt(data);
       }catch (IllegalArgumentException e){
           Output.printErrorNumbericMessage();
           return false;
       }
        return true;
    }

    public boolean validFitLottoCost(String data){
        if(Integer.parseInt(data) % LOTTO_COST != 0){
            Output.printErrorFitLottoCostMessage();
            return false;
        }
        return true;
    }
}
