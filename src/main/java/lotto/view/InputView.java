package lotto.service;

import camp.nextstep.edu.missionutils.Console;

public class InputService {
    private int purchaseAmount;

    public int readPurchaseAMount() {
        System.out.println("구입금액을 입력해 주세요.");
        this.purchaseAmount = Integer.parseInt(Console.readLine());
        return purchaseAmount;
    }
}
