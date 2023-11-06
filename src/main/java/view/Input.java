package view;

import camp.nextstep.edu.missionutils.Console;
import validator.LottoCostValidator;

public class Input {
    public Input(){};

    public static int getInputForLottoCost(){
        String inputData;
        LottoCostValidator lottoCostValidator = new LottoCostValidator();

        while(true){
            Output.printPurchaseCostRequestMessage();
            inputData = reanLineValidateNull();
            if(lottoCostValidator.validate(inputData))
                break;
        }
        return Integer.parseInt(inputData);
    }

    public static String reanLineValidateNull(){
        String input = Console.readLine();
        while(true){
            if(validateNull(input)){
                break;
            }
        }
        return input;
    }


    private static boolean validateNull(String input){
        try{
            if(input.equals("") || input == null){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e){
            Output.printErrorNullMessage();
            return false;
        }
        return  true;
    }

}
