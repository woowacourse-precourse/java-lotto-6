package lotto;

import lotto.domain.Money;
import lotto.view.Input;

public class GameController {

    public void start() {

    }

    private void insertMoney(){

        Money money = new Money(Integer.parseInt(Input.consoleLine()));

    }

}
