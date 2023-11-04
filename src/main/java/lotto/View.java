package lotto;

import static lotto.settings.Announcement.PURCHASE_AMOUNT_REQUEST;

public class View {

    public static void requestPurchaseAmount(){
        System.out.println(PURCHASE_AMOUNT_REQUEST.getPrint());
    }

}
