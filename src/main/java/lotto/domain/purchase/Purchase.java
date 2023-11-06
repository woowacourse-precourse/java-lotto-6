package lotto.domain.purchase;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {

    private int paidPrice;

    public int makePurchase() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String purchasePrice = Console.readLine();
            try {
                paidPrice = Integer.parseInt(purchasePrice);
                validatePrice(paidPrice);
                int lottoQuantity = paidPrice / 1000;
                System.out.println(lottoQuantity + "개를 구매했습니다.");
                return lottoQuantity;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입 금액은 1,000원 단위로 입력해 주세요.");
            }
        }
    }

    public void validatePrice(int paidPrice) {
        if (paidPrice % 1000 != 0 || paidPrice == 0) {
            throw new IllegalArgumentException();
        }
    }
}
