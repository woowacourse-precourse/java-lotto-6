package service;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {

    public void start() {
        int ticketPurchaseAmount = getTicketPurchaseAmount();
    }

    private static int getTicketPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int ticketPurchaseAmount = Integer.parseInt(Console.readLine());
        validateDivisor(ticketPurchaseAmount);
        return ticketPurchaseAmount;
    }

    public static void validateDivisor(int divisor) {
        if (divisor % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해야 합니다.");
        }
    }
}
