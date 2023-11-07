package lotto.config;

import lotto.domain.computer.Computer;
import lotto.domain.computer.RandomLottoGenerator;
import lotto.domain.computer.ResultGenerator;
import lotto.domain.game.Game;
import lotto.input.ConsoleInput;
import lotto.input.Input;
import lotto.output.ConsoleOutput;
import lotto.output.Output;

public class Configuration {

    public static Game game() {
        return new Game(input(), output(), computer());
    }

    private static Input input() {
        return new ConsoleInput();
    }

    private static Output output() {
        return new ConsoleOutput();
    }

    private static Computer computer() {
        return new Computer(randomLottoGenerator(), resultGenerator());
    }

    private static RandomLottoGenerator randomLottoGenerator() {
        return new RandomLottoGenerator();
    }

    private static ResultGenerator resultGenerator() {
        return new ResultGenerator();
    }
}
