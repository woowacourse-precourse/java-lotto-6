package lotto.service;

import camp.nextstep.edu.missionutils.Console;

public class InputService {
    private int purchaseAmount;

    public int readPurchaseAMount() {
        this.purchaseAmount = Integer.parseInt(Console.readLine());
        return purchaseAmount;
    }
}
