package view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public Input(){};

//    public static int getInputForLottoCost(){
//        String inputData;
//        LottoCostValidator lottoCostValidator = new LottoCostValidator();
//

//    }

    public String getInputForLottoMoney(){
        Output.printPurchaseCostRequestMessage();
        return reanLineValidateNull();
    }

    public String getInputForWinningNumber(){
        Output.printWinningNumberRequestMessage();
        return reanLineValidateNull();
    }

    public String reanLineValidateNull(){
        String input = Console.readLine();
        while(true){
            if(validateNull(input)){
                break;
            }
        }
        return input;
    }


    private boolean validateNull(String input){
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
