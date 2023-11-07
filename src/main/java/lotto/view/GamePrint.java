package lotto.view;

public class GamePrint {

    private static final String INPUT_PRICE = "구입금액을 입력해 주세요.";

    public static void inputPrice() {
        System.out.println(INPUT_PRICE);
    }

    public static void numberOfPurchases(int buyLottoNumber) {
        System.out.printf("\n%s개를 구매했습니다.\n", buyLottoNumber);
    }
}
