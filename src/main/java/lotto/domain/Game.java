package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.constant.InputMessage;
import lotto.constant.LottoNumber;
import lotto.ui.Input;
import lotto.ui.Output;

public class Game {
    private List<Lotto> createLottos() {
        while (true) {
            Output.printMessage(InputMessage.AMOUNT.getMessage());
            try {
                int amount = Input.readAmount(Console.readLine());
                return LottoMachine.issueLotto(amount / LottoNumber.PRICE.getValue());
            } catch (IllegalArgumentException exception) {
                Output.printMessage(exception.getMessage());
            }
        }
    }

    private Lotto createWinningNumber() {
        while (true) {
            Output.printMessage(InputMessage.WINNING_NUMBER.getMessage());
            try {
                List<Integer> numbers = Input.readWinningNumber(Console.readLine());
                return new Lotto(numbers);
            } catch (IllegalArgumentException exception) {
                Output.printMessage(exception.getMessage());
            }
        }
    }

    public void start() {
        List<Lotto> lottos = createLottos();
        Output.printLottos(lottos);
        Lotto winningNumber = createWinningNumber();
    }
}
