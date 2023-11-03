package lotto.domain.purchase;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {

    private int paidPrice;

    public int makePurchase() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchasePrice = Console.readLine();
        repeatPurchasing(purchasePrice);
        System.out.println();
        int lottoQuantity = paidPrice / 1000;
        System.out.println(lottoQuantity + "개를 구매했습니다.");

        return lottoQuantity;
    }

    public void repeatPurchasing(String purchasePrice) {

        while (true) {
            try {
                validatePrice(purchasePrice);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입 금액은 1,000원 단위로 입력해 주세요.");
            }
        }
    }

    public void validatePrice(String purchasePrice) {

        paidPrice = Integer.parseInt(purchasePrice);

        if (paidPrice % 1000 != 0) {
            throw new IllegalArgumentException();
        }

        if (paidPrice == 0) {
            throw new IllegalArgumentException();
        }
    }
}
