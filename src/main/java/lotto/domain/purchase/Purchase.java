package lotto.domain.purchase;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {
    private int paidPrice;

    public void makePurchase() {
        System.out.println("구입금액을 입력해 주세요.");
        purchaseLotto();
        System.out.println();
        int lottoQuantity = paidPrice / 1000;
        System.out.println(lottoQuantity + "개를 구매했습니다.");
        System.out.println();
    }

    public void purchaseLotto() {
        while (true) {
            try{
                String purchasePrice = Console.readLine();
                paidPrice = Integer.parseInt(purchasePrice);
                validatePrice(paidPrice);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입 금액은 1,000원 단위로 입력해 주세요.");
            }
        }
    }

    public void validatePrice(int paidPrice) {
        if (paidPrice % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
