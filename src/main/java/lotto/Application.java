package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        ProcessLotto processLotto = new ProcessLotto(inputView, outputView);
        processLotto.drawLotto();

    }
}
