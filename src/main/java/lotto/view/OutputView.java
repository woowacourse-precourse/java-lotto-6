package lotto.view;

public class OutputView {
    private final String AMOUNT_MESSAGE = "\n%d개를 구매했습니다";

    public void printAmount(int amount){
        System.out.println(String.format(AMOUNT_MESSAGE,amount));
    }
}
