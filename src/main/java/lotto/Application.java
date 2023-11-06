package lotto;

import lotto.model.Model;
import lotto.view.InputView;

public class Application {
    private final InputView inputView;

    public Application() {
        Model model = new Model();
        this.inputView = new InputView(model);
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.inputView.start();
    }
}
