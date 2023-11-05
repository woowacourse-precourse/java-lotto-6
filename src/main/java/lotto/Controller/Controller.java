package lotto.Controller;

import lotto.View.Input;
import lotto.View.Output;

public class Controller {

    public void playingGame(){
        startGame();
    }
    public void startGame(){
        Output.printEnterPurchaseMount();
        Integer playerInsert = Input.insertInteger();
    }
}
