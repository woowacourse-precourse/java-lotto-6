package lotto.view;


import static lotto.utility.Constants.BUY_MESSAGE_AFTER;
import static lotto.utility.Constants.BUY_MESSAGE_BEFORE;

public class UserView {
    public UserView() {}
    public void printBuyMessageBefore() {
        System.out.println(BUY_MESSAGE_BEFORE);
    }
    public void printBuyMessageAfter() {
        System.out.println(BUY_MESSAGE_AFTER);
    }
}
