package lotto.domain;


import static lotto.view.InputView.printLottoAmount;

public class LottoAmount {
    public static int price = 0;

    public LottoAmount() {
        purchaseAmountValidate();
        System.out.println(howManyLotto());
    }

    private static void lottoPrice() {
        price = printLottoAmount();
        System.out.println();
        purchaseAmount(price);
    }


    public static void purchaseAmount(int amount) throws IllegalArgumentException {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void purchaseAmountValidate() {
        try {
            lottoPrice();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 금액은 1000원 단위로 사용해야 합니다.");
            lottoPrice();
        }
    }

    public static int priceCalculation() {
        return price / 1000;
    }

    public static String howManyLotto() {
        return priceCalculation() + "개를 구매했습니다.";
    }
}
