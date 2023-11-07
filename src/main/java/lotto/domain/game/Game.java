package lotto.domain.game;

import static lotto.ExceptionHandler.handle;

import lotto.domain.computer.Computer;
import lotto.input.Input;
import lotto.output.Output;
import lotto.domain.user.User;

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
        User user = setUser();
        printUserLottos(user);
        setComputer();
        printResult(user);
    }

    private User setUser() {
        handle(this::getMoneyByInput);
        return new User(computer.createUserLottos());
    }

    private void getMoneyByInput() {
        output.print("구입금액을 입력해 주세요.");
        computer.setMoney(input.readNumber());
    }

    private void printUserLottos(User user) {
        output.print(user.lottos().lottoList().size() + "개를 구매했습니다.");
        output.print(user.lottos());
    }

    private void setComputer() {
        handle(this::setWinningLotto);
        handle(this::setBonusNumber);
    }

    private void setWinningLotto() {
        output.print("당첨 번호를 입력해 주세요.");
        computer.setLottoNumber(input.readList());
    }

    private void setBonusNumber() {
        output.print("보너스 번호를 입력해 주세요.");
        computer.setBonusNumber(input.readNumber());
    }

    private void printResult(User user) {
        output.print("당첨 통계\n---\n");
        output.print(computer.createResult(user.lottos()));
    }
}
