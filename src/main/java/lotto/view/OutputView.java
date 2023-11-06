package lotto.view;

public class OutputView {
    private static final String buyPrice = "구입금액을 입력해 주세요.";
    private static final String buyAmount = "개를 구매했습니다.";

    public static void PrintBuyPrice() {
        System.out.println(buyPrice);
    }
    public static void PrintBuyAmount(int buyAmount){
        System.out.println(buyAmount + buyAmount);
    }


}
