package lotto.controller;

import lotto.ErrorMessage;
import lotto.model.GameMoney;
import lotto.view.InputView;

public class GetBuyNumber {

    private final InputView inputView=new InputView();

    public GameMoney getBuyNumber(){
        String money=inputView.inputMoney();
        return getValid(money);
    }

    public GameMoney getValid(String money){
        int moneyNum;

        try{
            moneyNum=Integer.parseInt(money);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_NUMBER.toString());
        }
        if(moneyNum<=0){
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_NATURAL_NUM.toString());
        }
        if(moneyNum%1000!=0){
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_THOUSANDS_UNIT.toString());
        }
        return new GameMoney(moneyNum);
    }

}
