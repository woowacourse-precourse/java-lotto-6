package lotto;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoController lottoController = new LottoController(inputView);

        lottoController.run();
    }
}
