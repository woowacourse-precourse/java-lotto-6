package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.constant.InputMessage;
import lotto.constant.Number;
import lotto.ui.Input;
import lotto.ui.Output;

public class Game {
    public void start() {
        int amount = 0;
        while (true) {
            Output.printMessage(InputMessage.AMOUNT.getMessage());
            try {
                amount = Input.readAmount(Console.readLine());
                break;
            } catch (IllegalArgumentException exception) {
                Output.printMessage(exception.getMessage());
            }
        }
        List<Lotto> lottos = LottoMachine.issueLotto(amount / Number.PRICE.getValue());
    }
}
