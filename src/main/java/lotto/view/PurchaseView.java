package lotto.view;

import lotto.constant.message.SettingMessage;

public class PurchaseView {
    public static void printInputPurchaseAmount(){
        System.out.println(SettingMessage.INPUT_PURCHASE_AMOUNT);
    }

    public static void printPurchasedTicketCount(int number){
        System.out.printf((SettingMessage.NOTICE_PURCHASED_TICKET_COUNT) + "%n", number);
    }
}
