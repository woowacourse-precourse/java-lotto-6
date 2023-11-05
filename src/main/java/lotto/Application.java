package lotto;

import lotto.domain.LottoAmount;
import lotto.io.InputHandler;

public class Application {
    public static void main(String[] args) {
        generateLottoAmount();
    }

    public static void generateLottoAmount() {
        boolean validated = false;
        while (!validated) {
            InputHandler inputHandler = new InputHandler();
            String input = inputHandler.askAmount();

            LottoAmount lottoAmount = new LottoAmount();
            validated = lottoAmount.validate(input);
        }
    }
}
