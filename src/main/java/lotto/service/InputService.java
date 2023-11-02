package lotto.service;

import camp.nextstep.edu.missionutils.Console;

public class InputService {
    private int purchaseAmount;

    public int readPurchaseAMount() {
        this.purchaseAmount = Integer.parseInt(Console.readLine());
        validateMultipleOfThousand(purchaseAmount);
        return purchaseAmount;
    }

    public void validateMultipleOfThousand(int purchaseAmount) {
        if (purchaseAmount % 1000 == 0) {
            throw new IllegalArgumentException();
        }
    }

}
