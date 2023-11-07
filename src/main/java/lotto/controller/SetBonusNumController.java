package lotto.controller;

import lotto.service.SetBonusNumService;
import lotto.view.Input;
import lotto.view.Output;
import lotto.vo.BonusNumber;

public class SetBonusNumController {
    BonusNumber bonusNumber;
    public void setBonusNum(){
        Input input = new Input();
        Output output = new Output();
        SetBonusNumService service = null;

        boolean checkException = false;
        while (!checkException) {
            service = new SetBonusNumService();
            output.printBonusNumberPrompt();
            try{
                String number = input.get();
                checkException = service.checkException(number);
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
        this.bonusNumber = new BonusNumber(service.getBonusNumber());
    }

    public BonusNumber getBonusNumber(){
        return this.bonusNumber;
    }
}
