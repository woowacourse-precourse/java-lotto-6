package Except;

import Input.Input;
import Message.Message;

public class Except {
    private static Message outOfRange = Message.moneyOutOfRange;
    private static Message invalidFormat = Message.moneyInvalidFormat;
    private static final String INTEGER_REGEX = "^-?\\d+$";
    public int outOfRangeMoney(String money){
        int result = outOfRange.getCode();
        Input input = new Input();
        try{
            if(!money.matches(INTEGER_REGEX)){
                throw new IllegalArgumentException();
            }
            result = Integer.parseInt(money);
            result = incorrectFormatMoney(result);
        }catch(IllegalArgumentException iae){
            System.out.println(outOfRange.getMessage());
        }
        return result;
    }

    public int incorrectFormatMoney(int money){
        int result = invalidFormat.getCode();
        try{
            if(money<0||money%1000!=0){
                throw new IllegalArgumentException();
            }
        }catch(IllegalArgumentException iae){
            System.out.println(invalidFormat.getMessage());
        }
        return result;
    }
}
