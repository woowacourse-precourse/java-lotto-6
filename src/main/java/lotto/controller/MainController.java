package lotto.controller;

import lotto.model.Lotto;
import lotto.model.User;

public class MainController {
    private static MainController intstance;
    private MainController(){}
    public static MainController getIntstance(){
        if(intstance == null){
            intstance = new MainController();
        }
        return intstance;
    }



}
