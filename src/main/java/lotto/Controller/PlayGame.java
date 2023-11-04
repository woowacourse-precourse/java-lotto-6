package lotto.Controller;

import lotto.Model.Setting;

public class PlayGame {
    Setting setting = new Setting();

    public void play(){
        int i =setting.purchase_amount();
        System.out.println(i);
    }
}
