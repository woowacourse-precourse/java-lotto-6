package lotto.Controller;

import lotto.View.View;

public class Controller {
    public void LotteStart(){
        View view = new View();
        int myMoney = view.buyMoney();
        view.buyLotto(myMoney);
    }
}
