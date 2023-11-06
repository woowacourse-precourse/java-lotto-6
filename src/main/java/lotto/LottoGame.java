package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoGame {
    public void execute() {
        int purchaseMoney = purchase();
    }

    private int purchase() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            int purchaseMoney;
            try {
                purchaseMoney = Integer.parseInt(Console.readLine());
                validatePurchaseMoney(purchaseMoney);
                return purchaseMoney;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입금액은 1,000단위 숫자여야 합니다.");
            }
        }
    }

    private void validatePurchaseMoney(int purchaseMoney) {
        if (purchaseMoney % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}