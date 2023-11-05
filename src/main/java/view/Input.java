package view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public Input(){};


    public int getInputForLottoCost(){
        String inputData = reanLineValidateNull();

    }

    public String reanLineValidateNull(){
        String input = Console.readLine();
        validateNull(input);
        return input;
    }

    private void validateNull(String input){
        try{
            if(input.equals("") || input == null){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e){
            Output.printErrorNullMessage();
        }
    }

}
