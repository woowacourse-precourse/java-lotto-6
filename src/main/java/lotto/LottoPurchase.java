package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoPurchase {

    private static final int LOTTO_PRICE_UNIT = 1000;

    public int requestPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                return validateAmount(Integer.parseInt(input));
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0원 이상이어야 합니다.");
        }
        if (amount % LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
        return amount;
    }

}
