package lotto.controller;

import lotto.model.WinningNumber;
import lotto.view.UserInput;

public class WinningNumberController {
    private final UserInput userInput;
    private WinningNumber winningNumber;

    public WinningNumberController() {
        userInput = new UserInput();
    }
    public void setWinningNumber(){
        try {
            this.winningNumber = new WinningNumber(userInput.inputWinnerNumber());
        }
        catch (IllegalArgumentException e){
            System.out.println("[ERROR]:중복된 수를 입력하지 마세요");
            setWinningNumber();
        }
    }
}
