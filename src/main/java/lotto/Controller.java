package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Controller {
    public Integer getPurchaseQuantity() {
        int purchaseAmount = Integer.parseInt(Console.readLine().trim());

        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }

        return purchaseAmount / 1000;
    }
}
