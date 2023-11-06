package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ProcessLotto processLotto = new ProcessLotto(new InputView(), new OutputView());
        processLotto.drawLotto(new ValidateTools());

    }
}
