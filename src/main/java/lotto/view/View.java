package lotto.view;

import static lotto.settings.Announcement.LOTTO_BONUS_NUMBERS_REQUEST;
import static lotto.settings.Announcement.LOTTO_WINNING_NUMBERS_REQUEST;
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

    public static void requestWinningNumber(){
        print(LOTTO_WINNING_NUMBERS_REQUEST);
    }

    public static void requestBonusNumber(){
        print(LOTTO_BONUS_NUMBERS_REQUEST);
    }

    private static void print(Announcement announcement){
        System.out.println(announcement.getPrint());
    }
}
