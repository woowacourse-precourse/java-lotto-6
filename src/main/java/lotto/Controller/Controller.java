package lotto.Controller;

import lotto.View.View;
import lotto.domain.*;
import lotto.mapper.Mapper;
public class Controller {

    private final View view;

    public Controller() {
        this.view = new View();
    }

    public void start() {
        PurchaseMoney purchaseMoney = insertMoney();

    }

    private PurchaseMoney insertMoney() {
        return new PurchaseMoney(view.getPurchasePrice());
    }

}
