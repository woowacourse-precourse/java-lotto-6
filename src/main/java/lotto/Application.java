package lotto;

import lotto.io.UserInput;
import lotto.io.UserOutput;

public class Application {

    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        UserOutput userOutput = new UserOutput();

        LottoGame lottoGame = new LottoGame(
                userInput,
                userOutput
        );

        try {
            lottoGame.play();
        } catch (RuntimeException runtimeException) {
            userOutput.print("[ERROR] " + runtimeException.getMessage());
        }
    }
}
