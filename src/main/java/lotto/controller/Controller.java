package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.utils.Parser;
import lotto.view.RequestMessage;

import java.util.List;

public class Controller {

    private static final int TICKET_PRICE=1000;

    Parser parser = new Parser();

    public void run(){
        startLotto();
    }

    private void startLotto(){
        Amount amount = requestPlayerAmountInput();
        Lotto winningNum = requestPlayerWinningInput();
        int bonusNum = requestPlayerBonusInput();
    }

    private Amount requestPlayerAmountInput(){
        RequestMessage.requestTotalPrice();
        int playerAmountInput = parser.stringToInteger(Console.readLine());
        return new Amount(playerAmountInput, TICKET_PRICE);
    }

    private Lotto requestPlayerWinningInput(){
        RequestMessage.requestWinningNum();
        List<Integer> playerWinningInput = parser.translatePlayerInputStringToInt(Console.readLine());
        return new Lotto(playerWinningInput);
    }

    private int requestPlayerBonusInput(){
        RequestMessage.requestBonusNum();
        return parser.stringToInteger(Console.readLine());
    }
}
