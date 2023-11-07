package lotto.controller;

import lotto.model.Lotto;
import lotto.model.User;

public class MainController {
    private static MainController intstance;
    private static User user = new User();
    private MainController(){}
    public static MainController getIntstance(){
        if(intstance == null){
            intstance = new MainController();
        }
        return intstance;
    }

    public static void startLotto(){
        user.getMoney();
        user.getTicketCount();
        user.getLottosThroughTicketCount();

        user.getWinLotto();
        user.getBonusNumber();

    }

}
