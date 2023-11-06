package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BuyingController buyingController = new BuyingController();
        buyingController.handle();

        LottoNumberAddController lottoNumberAddController = new LottoNumberAddController();
        lottoNumberAddController.handle();
    }
}
