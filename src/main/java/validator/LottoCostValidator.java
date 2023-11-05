package validator;

import dto.RottoCostRequst;
import view.Output;

public class LottoCostValidator {
    public boolean validate(String input){
        if(validNumberic(input) && )
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


}
