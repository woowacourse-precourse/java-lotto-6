package lotto.controller;

import lotto.domain.Buyer;
import lotto.view.inputMessage;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.util.Utils.ChangeStringToInt;

public class Controller {

    public void playGame(){
        buyLotto();
    }
    public void buyLotto(){
        inputMessage.priceMessage();
        String price = readLine();
        Buyer buyer = new Buyer(ChangeStringToInt(price));

    }

}
