package lotto;

public class Application {
    public static void main(String[] args) {
        new LottoController(new InputView(), new OutputView(), new LottoService())
                .run();
    }
}
