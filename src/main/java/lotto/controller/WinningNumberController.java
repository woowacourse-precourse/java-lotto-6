package lotto.controller;

import java.util.List;
import lotto.model.WinningNumber;
import lotto.view.UserInput;
import lotto.view.UserOutput;

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
            System.out.println("[ERROR]:중복된 수를 입력하지 마세요");
            setWinningNumber();
        }
        winningNumber.setBonusNumber(userInput.inputBonusNumber());
        return winningNumber;
    }
}
