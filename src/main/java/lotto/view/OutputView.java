package lotto.view;

public class OutputView {
    private final String PURCHASES_NUMBER = "개를 구매했습니다.";

    public void purchasesNumberView(int AMOUNT){
        System.out.println(AMOUNT + PURCHASES_NUMBER);
    }
}
