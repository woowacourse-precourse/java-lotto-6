package lotto;

import lotto.engine.GameEngine;
import lotto.engine.GameEngineValidator;
import lotto.numbergenerator.NextStepNumberGenerator;
import lotto.numbergenerator.NumberGenerator;
import lotto.reader.InputReader;
import lotto.reader.NextStepConsoleReader;
import lotto.ui.Ui;

public class AppConfig {
    private NumberGenerator getNumberGenerator() {
        return new NextStepNumberGenerator();
    }

    GameEngine getGameEngine() {
        return new GameEngine(getGameEngineValidator(), getNumberGenerator());
    }

    private GameEngineValidator getGameEngineValidator() {
        return new GameEngineValidator();
    }

    public Ui getUi() {
        return new Ui();
    }

    public InputReader getInputReader() {
        return new NextStepConsoleReader();
    }
}
