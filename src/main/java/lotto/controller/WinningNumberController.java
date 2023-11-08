package lotto.controller;

import lotto.model.WinningNumber;
import lotto.view.UserInput;

public class WinningNumberController {
    private final UserInput userInput;
    private WinningNumber winningNumber;

    public WinningNumberController() {
        userInput = new UserInput();
    }
    public WinningNumber setWinningNumber(){
        System.out.println("당첨 번호를 입력해주세요");
        try {
            this.winningNumber = new WinningNumber(userInput.inputWinnerNumber());
        }
        catch (IllegalArgumentException e){
            System.out.println("[ERROR]:올바른 입력값을 입력하세요");
            setWinningNumber();
        }
        setBonusNumber();
        return winningNumber;
    }
    public void setBonusNumber(){
        try {
            this.winningNumber.setBonusNumber(userInput.inputBonusNumber());
        }
        catch (IllegalArgumentException e){
            System.out.println("[ERROR]: 올바른 입력값을 입력하세요");
            setBonusNumber();
        }
    }
}
