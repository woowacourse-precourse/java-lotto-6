package lotto.controller;

import lotto.service.SetWinningNumService;
import lotto.view.Input;
import lotto.view.Output;
import lotto.vo.WinningNumber;

import java.util.List;

public class SetWinningNumController {
    WinningNumber winningNumber;
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

        this.winningNumber = new WinningNumber(service.getWinningNumber());
    }

    public WinningNumber getWinningNumber(){
        return winningNumber;
    }
}