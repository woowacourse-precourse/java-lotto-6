package view;

public class LottoCount {
    private static final String OUTPUT_MESSAGE = "%d개를 구매했습니다.";

    public static void printBuyLotto(int count) {
        System.out.printf((OUTPUT_MESSAGE) + "%n", lottoCount());
    }

    private static int lottoCount(){
        return InputPrice.enterPurchaseAmount() / 1000;
    }

}
