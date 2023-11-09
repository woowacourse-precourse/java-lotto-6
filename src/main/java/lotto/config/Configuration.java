package lotto.config;

import static lotto.constant.LottoNumber.*;

import lotto.constant.LottoNumber;
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
        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();
        randomLottoGenerator.setMaxMoney(DEFAULT_MAX_AMOUNT_OF_LOTTO.getNumber()); //최대 로또 구입 금액 설정
        return randomLottoGenerator;
    }

    private static ResultGenerator resultGenerator() {
        return new ResultGenerator();
    }
}
