package lotto;

import camp.nextstep.edu.missionutils.Console;

public class GetInput {
    public static int askPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseMoney = Console.readLine();
        return Integer.parseInt(purchaseMoney);
    }
}
