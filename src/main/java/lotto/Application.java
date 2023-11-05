package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Purchase;

public class Application {
    public static void main(String[] args) {
        Purchase purchase = new Purchase(Console.readLine());
        System.out.println(purchase.getAmount());
        purchase.getPurchasedLotto();
    }
}
