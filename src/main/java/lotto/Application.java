package lotto;

public class Application {
    public static void main(String[] args) {

        LottoView lottoView = new LottoView();
        LottoController lottoController = new LottoController(lottoView);
        lottoController.start();
    }
}
