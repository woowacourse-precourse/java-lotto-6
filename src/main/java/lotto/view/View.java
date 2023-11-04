package lotto.view;

import static lotto.settings.Announcement.PURCHASE_AMOUNT_REQUEST;
import static lotto.settings.Announcement.PURCHASE_NUMBER;

import lotto.settings.Announcement;

public class View {

    public static void requestPurchaseAmount(){
        print(PURCHASE_AMOUNT_REQUEST);
    }

    public static void purchaseCount(int count){
        System.out.printf(PURCHASE_NUMBER.getPrint(), count);
    }


    private static void print(Announcement announcement){
        System.out.println(announcement.getPrint());
    }

}
