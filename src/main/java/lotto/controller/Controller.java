package lotto.controller;

import lotto.domain.Buyer;
import lotto.util.Utils;
import lotto.view.inputMessage;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.util.Utils.ChangeStringToInt;

public class Controller {

    public void playGame(){
        buyLotto();
    }
    public void buyLotto(){
        inputMessage.priceMessage();
        int price = ChangeStringToInt(readLine());
        Buyer buyer = new Buyer(price);
    }

    public int getPrizeNumber(){
        inputMessage.prizeMessage();
        return Utils.ChangeStringToInt(readLine());
    }

    public int getBonusNumber(){
        inputMessage.bonusMessage();
        return Utils.ChangeStringToInt(readLine());
    }

}
