package view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public Input(){};

    public String getInputForLottoMoney(){
        Output.printPurchaseCostRequestMessage();
        return reanLineValidateNull();
    }

    public String getInputForWinningNumber(){
        Output.print();
        Output.printWinningNumberRequestMessage();
        return reanLineValidateNull();
    }

    public String getInputForBonusNumber(){
        Output.print();
        Output.printBonusNumberRequestMessage();
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
