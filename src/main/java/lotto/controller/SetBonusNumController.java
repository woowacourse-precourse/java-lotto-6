package lotto.controller;

import lotto.service.SetBonusNumService;
import lotto.view.Input;
import lotto.view.Output;
import lotto.vo.BonusNumber;

public class SetBonusNumController {
    BonusNumber bonusNumber;
    public SetBonusNumController(){
        setBonusNum();
    }
    public void setBonusNum(){
        Input input = new Input();
        Output output = new Output();
        SetBonusNumService service = new SetBonusNumService();

        while (bonusNumber==null) {
            output.printBonusNumberPrompt();
            String number = input.get();
            try{
                bonusNumber = service.generateBonusNum(number);
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
    }

    public BonusNumber getBonusNumber(){
        return this.bonusNumber;
    }
}
