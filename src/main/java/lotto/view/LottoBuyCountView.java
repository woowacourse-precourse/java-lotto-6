package lotto.view;

public class LottoBuyCountView implements View {
    private final String OUTPUT = "%d개를 구매하였습니다.";
    private final int buyCount;

    public LottoBuyCountView(int buyCount) {
        this.buyCount = buyCount;
    }

    @Override
    public void render() {
        System.out.println(String.format(OUTPUT, buyCount));
    }
}
