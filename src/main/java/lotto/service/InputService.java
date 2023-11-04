package lotto.service;

import camp.nextstep.edu.missionutils.Console;

public class InputService {
    private int purchaseAmount;

    public int readPurchaseAMount() {
        System.out.println("구입금액을 입력해 주세요.");
        this.purchaseAmount = Integer.parseInt(Console.readLine());
        validatePositive(purchaseAmount);
        validateMultipleOfThousand(purchaseAmount);
        return purchaseAmount;
    }

    public void validatePositive(int purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException();
        }
    }

    public void validateMultipleOfThousand(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getLottoTicketCount() {
        return readPurchaseAMount() / 1000;
    }

}
