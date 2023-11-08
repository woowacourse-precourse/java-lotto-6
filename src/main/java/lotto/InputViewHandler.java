package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputViewHandler {

    public Money inputMoney(){
        Money money = new Money();
        try{
            String input = Console.readLine();
            money = new Money(Integer.parseInt(input));
            return money;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            inputMoney();
        }
        return money;
    }

    public CalculateLotto inputAnswerLotto(){
        CalculateLotto lotto = new CalculateLotto();
        try{
            lotto = new CalculateLotto(Console.readLine());
            return lotto;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            inputAnswerLotto();
        }
        return lotto;
    }

    public BonusNumber inputBonusNumber(){
        BonusNumber bonusNumber = new BonusNumber();
        try{
            bonusNumber = new BonusNumber(Console.readLine());
            return bonusNumber;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            inputBonusNumber();
        }
        return bonusNumber;
    }
}
