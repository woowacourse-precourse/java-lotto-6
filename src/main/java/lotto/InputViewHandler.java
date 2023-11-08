package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputViewHandler {

    public Money inputMoney(){
        Money money = new Money();
        try{
            money = new Money(Integer.parseInt(Console.readLine()));
        }catch (IllegalArgumentException e){
            inputMoney();
        }
        return money;
    }

    public CalculateLotto inputAnswerLotto(){
        CalculateLotto lotto = new CalculateLotto();
        try{
            lotto = new CalculateLotto(Console.readLine());
        }catch (IllegalArgumentException e){
            inputAnswerLotto();
        }
        return lotto;
    }

    public BonusNumber inputBonusNumber(){
        BonusNumber bonusNumber = new BonusNumber();
        try{
            bonusNumber = new BonusNumber(Console.readLine());
        }catch (IllegalArgumentException e){
            inputBonusNumber();
        }
        return bonusNumber;
    }
}
