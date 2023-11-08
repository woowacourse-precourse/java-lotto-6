package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class getPurchaseAmount {
    public int getPurchaseAmount() throws Exception {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmountStr = readLine();

        int purchaseAmount;
        try {
            purchaseAmount = Integer.parseInt(purchaseAmountStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입금액은 숫자여야 합니다.");
        }

        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("구입금액은 1,000원 단위여야 합니다.");
        }

        return purchaseAmount;
    }
}
