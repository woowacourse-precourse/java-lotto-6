package lotto.domain.game;

import static lotto.ExceptionHandler.restartWhenExceptionOccur;
import static lotto.constant.GameGuideMessage.ENTER_BONUS_NUMBER;
import static lotto.constant.GameGuideMessage.ENTER_PURCHASE_AMOUNT;
import static lotto.constant.GameGuideMessage.ENTER_WINNING_LOTTO;
import static lotto.constant.GameGuideMessage.PURCHASE_LOTTO;
import static lotto.constant.GameGuideMessage.WINNING_STATISTICS;

import lotto.domain.computer.Computer;
import lotto.domain.lotto.Lottos;
import lotto.domain.user.User;
import lotto.input.Input;
import lotto.output.Output;

public class Game {

    private final Input input;
    private final Output output;
    private final Computer computer;

    public Game(Input input, Output output, Computer computer) {
        this.input = input;
        this.output = output;
        this.computer = computer;
    }

    public void play() {
        setMoneyOnComputer();

        User user = new User(buyLottoFromComputer());
        printUserLottos(user);

        setWinningLottoAndBonusNumberOnComputer();

        printUserResult(user);
    }

    private void setMoneyOnComputer() {
        restartWhenExceptionOccur(this::setMoney);
    }

    private void setMoney() {
        output.print(ENTER_PURCHASE_AMOUNT);
        computer.setMoney(input.readNumber());
    }

    private Lottos buyLottoFromComputer() {
        return computer.createRandomLottos();
    }

    private void printUserLottos(User user) {
        output.print(String.valueOf(user.lottos().lottoList().size()) + PURCHASE_LOTTO);
        output.print(user.lottos());
    }

    private void setWinningLottoAndBonusNumberOnComputer() {
        restartWhenExceptionOccur(this::setWinningLotto);
        restartWhenExceptionOccur(this::setBonusNumber);
    }

    private void setWinningLotto() {
        output.print(ENTER_WINNING_LOTTO);
        computer.setLottoNumber(input.readList());
    }

    private void setBonusNumber() {
        output.print(ENTER_BONUS_NUMBER);
        computer.setBonusNumber(input.readNumber());
    }

    private void printUserResult(User user) {
        output.print(WINNING_STATISTICS);
        output.print(computer.createResult(user.lottos()));
    }
}
