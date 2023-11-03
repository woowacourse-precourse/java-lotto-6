package lotto.view;

public class LottoBuyCountView extends BasicView {
    private static final String OUTPUT = "%d개를 구매하였습니다.";

    public LottoBuyCountView(int buyCount) {
        super(String.format(OUTPUT, buyCount));
    }
}
