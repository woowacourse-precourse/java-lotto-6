package lotto;

import java.util.function.Consumer;
import lotto.engine.GameEngine;
import lotto.reader.InputReader;
import lotto.ui.Ui;

public class Game {
    private final GameEngine gameEngine;
    private final InputReader inputReader;
    private final Ui ui;

    public Game(AppConfig appConfig) {
        gameEngine = appConfig.getGameEngine();
        inputReader = appConfig.getInputReader();
        ui = appConfig.getUi();
    }

    public void run() {
        inputPrice();
        printLottos();
        inputLottoNumbers();
        inputBonusNumbers();
        printLottoResult();
        end();
    }

    private void end() {
        inputReader.close();
    }

    private void printLottoResult() {
        ui.printLottoResult(gameEngine.getCalculateScore(), gameEngine.getEarningPercent());
    }

    private void inputBonusNumbers() {
        ui.printReadBonusLottoNumber();
        retryIfThrowIllgalArgumentException((String readLine) -> gameEngine.createAnswerBonusNumber(readLine));
    }

    private void inputLottoNumbers() {
        ui.printReadLottoNumber();
        retryIfThrowIllgalArgumentException((String readLine) -> gameEngine.createAnswerLotto(readLine));
    }

    private void printLottos() {
        ui.printLotto(gameEngine.getLottos());
    }

    private void inputPrice() {
        ui.printPrice();
        retryIfThrowIllgalArgumentException((String readLine) -> gameEngine.createLottos(readLine));
    }

    private void retryIfThrowIllgalArgumentException(Consumer<? super String> canExceptionMethod) {
        try {
            canExceptionMethod.accept(inputReader.readLine());
        } catch (IllegalArgumentException exception) {
            ui.printError(exception);
            retryIfThrowIllgalArgumentException(canExceptionMethod);
        }
    }

}
