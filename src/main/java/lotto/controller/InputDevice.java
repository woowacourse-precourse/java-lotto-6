package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.ErrorMessage;
import lotto.view.Printer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputDevice {
    public Integer inputLottoPurchasePayment(){
        while(true){
            Printer.printInputLottoPurchasePayment();
            try{
                String inputValue = Console.readLine();
                checkValidLottoPurchasePayment(inputValue);
                return Integer.valueOf(inputValue);
            } catch (IllegalArgumentException e){
                Printer.printErrorMessage(ErrorMessage.INVALID_PURCHASE_PAYMENT.getMessage());
            }
        }
    }

    private void checkValidLottoPurchasePayment(String inputValue){
        checkIsNumber(inputValue);
        Integer number = Integer.parseInt(inputValue);
        checkValidNumber(number);
    }

    private void checkIsNumber(String inputValue){
        String regex = "^[1-9]\\d*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputValue);
        if(!matcher.matches()){
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_PAYMENT.getMessage());
        }
    }

    private void checkValidNumber(Integer number){
        int term = number % 1_000;
        if(term != 0){
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_PAYMENT.getMessage());
        }
    }
}
