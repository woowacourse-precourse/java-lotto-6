package lotto;

public class Application {
    public static void main(String[] args) {
        LottoBuyer buyer = new LottoBuyer();
        LottoManager manager = new LottoManager(buyer);
        manager.lottoSellingStart();
    }
}
