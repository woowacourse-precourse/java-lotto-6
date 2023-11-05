package lotto;

import lotto.ui.InputHandler;
import lotto.ui.OutputHandler;

public class Application {

    private final OutputHandler outputHandler;
    private final InputHandler inputHandler;

    public Application(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
        this.inputHandler = new InputHandler(this.outputHandler);
    }

    public static void main(String[] args) {
        OutputHandler outputHandler = new OutputHandler();
        Application application = new Application(outputHandler);
        application.run();

    }

    public void run () {
        int purchaseAmount = getPurchaseAmount();
    }

    private int getPurchaseAmount() {
        try {
            return inputHandler.getValidPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount();
        }
    }
}
