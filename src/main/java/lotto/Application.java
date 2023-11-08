package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Purchase purchase = new Purchase();
        Target target = new Target();

        purchase.getTickets();

        Lotto targetNumber = target.targetNums();
        int bonusNumber = target.bonusNum();
    }
}
