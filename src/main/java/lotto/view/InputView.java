package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.MoneyController;
import lotto.model.Money;

public class InputView {
    public static final String ERROR_MESSAGE = "[ERROR]";

    MoneyController moneyController = new MoneyController();

    public void inputMoneyInfo(){
        printInputMessage();
        moneyController.getMoney();
        printPlayCountMessage();
    }
    public void BuyLottoInfo(){
        
    }

    public void printInputMessage(){
        System.out.println("구입 금액을 입력해 주세요.");
    }
    public void printPlayCountMessage(){
        System.out.println(moneyController.getPlayCount()+"개를 구매했습니다.");
    }

}
