package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;


public class Ui {

    public void print(String notification) {

        System.out.println(notification);
    }

    public String input() {

        return Console.readLine();
    }

    public Integer checkPurchaseAmount(String inputAmount) {

        try {
            int intInput = checkInteger(inputAmount);
            checkNegative(intInput);
            return check1000(intInput);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public int checkInteger(String input) {

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            print(ExceptionMessage.notInteger.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public void checkNegative(int input) {

        if (input < 0) {
            print(ExceptionMessage.negativeValue.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public Integer check1000(int input) {

        if (input % 1000 != 0) {
            print(ExceptionMessage.not1000Value.getMessage());
            throw new IllegalArgumentException();
        }

        return input/1000;
    }

    public Lotto checkWinningInput(String input){

        List<Integer> winningValue = new ArrayList<>();
        String [] stringValues = splitInput(input);
        try{
            checkNumOfInput(stringValues);
            for(String stringValue : stringValues){
                winningValue.add(checkValidIntValue(stringValue));
            }
            return new Lotto(winningValue);
        } catch (IllegalArgumentException e){
            return null;
        }
    }

    public Integer checkBonusInput(String input){

        try{
            return checkValidIntValue(input);
        } catch (IllegalArgumentException e){
            return null;
        }
    }

    public Integer checkValidIntValue(String input){

        int intValue = checkInteger(input.trim());
        checkRangeOfInput(intValue);

        return intValue;
    }

    public String[] splitInput(String input){

        return input.split(",");
    }

    public void checkNumOfInput(String [] input){

        if(input.length != 6){
            print(ExceptionMessage.lottoNumber.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public void checkRangeOfInput(int input){

        if(input < 1 || 45 < input){
            print(ExceptionMessage.rangeNumber.getMessage());
            throw new IllegalArgumentException();
        }
    }
}
