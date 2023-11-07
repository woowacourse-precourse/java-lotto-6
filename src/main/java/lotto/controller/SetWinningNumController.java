package lotto.controller;

import lotto.service.SetWinningNumService;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class SetWinningNumController {
    List<Integer> winningNumber;
    public void setWinningNum(){
        Input input = new Input();
        Output output = new Output();

        SetWinningNumService service = null;
        boolean checkException = false;
        while(!checkException){
            service = new SetWinningNumService();
            output.printWinningNumberPrompt();
            try{
                String numbers = input.get();
                checkException = service.checkException(numbers);
            }catch (IllegalArgumentException e){
                output.printError(e.getMessage());
            }
        }

        this.winningNumber = service.getWinningNumber();
    }

    public List<Integer> getWinningNumber(){
        return winningNumber;
    }
}