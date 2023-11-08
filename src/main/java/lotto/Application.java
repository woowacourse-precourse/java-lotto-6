package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Cashier;

public class Application {
    public static void main(String[] args) {
        MessageContainer messageContainer = new MessageContainer();
        Cashier cashier;

        while (true) {
            System.out.println(messageContainer.getEnterPurchaseAmount());
            try {
                cashier = new Cashier(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

    }
}
