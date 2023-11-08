package lotto;

import lotto.io.UserInput;
import lotto.io.UserOutput;

public class Application {

    public static void main(String[] args) {
        LottoGame lottoGame = setupGame();
        executeLottoGame(lottoGame);
    }

    private static LottoGame setupGame() {
        UserInput userInput = new UserInput();
        UserOutput userOutput = new UserOutput();
        LottoMachine lottoMachine = new LottoMachine(new RandomGenerator());
        LottoInputParser lottoInputParser = new LottoInputParser();
        LottoComparator lottoComparator = new LottoComparator();

        return new LottoGame(
                userInput,
                userOutput,
                lottoMachine,
                lottoInputParser,
                lottoComparator
        );
    }

    private static void executeLottoGame(LottoGame lottoGame) {
        try {
            lottoGame.play();
        } catch (RuntimeException runtimeException) {
            lottoGame.getOutput().print("[ERROR] " + runtimeException.getMessage());
        }
    }
}
