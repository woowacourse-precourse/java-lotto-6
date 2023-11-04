package lotto.view;

import static lotto.settings.Announcement.PURCHASE_AMOUNT_REQUEST;

import lotto.settings.Announcement;

public class View {

    public static void requestPurchaseAmount(){
        print(PURCHASE_AMOUNT_REQUEST);
    }

    private static void print(Announcement announcement){
        System.out.println(announcement.getPrint());
    }

}
