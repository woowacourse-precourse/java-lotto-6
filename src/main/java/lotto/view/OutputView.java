package lotto.view;

public class OutputView {
    private static final String PURCHASE_LOTTO = "%d개를 구매했습니다.\n";

    public static void purchaseLotto(int lottoCount){
        System.out.printf(PURCHASE_LOTTO,lottoCount);
    }
}
