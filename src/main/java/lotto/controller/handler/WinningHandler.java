package lotto.controller.handler;

import lotto.domain.model.Bonus;
import lotto.domain.model.Lotto;
import lotto.domain.service.LottoService;
import lotto.ui.input.InputView;
import lotto.ui.output.OutputView;

import java.util.List;

import static lotto.controller.util.Conversion.makeInt;
import static lotto.controller.util.Conversion.makeIntegerList;

public class WinningHandler {

    private Lotto main;
    private Bonus bonus;

    public void processWinningOngoing(String message) {
        String input;
        do {
            OutputView.printMessage(message);
            input = InputView.input();
        } while (hasExceptionWinningOngoing(input));
    }

    public void processWinningComplete(String message, LottoService service) {
        String input;
        do {
            OutputView.printMessage(message);
            input = InputView.input();
        } while (hasExceptionWinningComplete(input, service));
    }

    private boolean hasExceptionWinningOngoing(String input) {
        try {
            List<Integer> winningMain = makeIntegerList(input);
            main =  new Lotto(winningMain);
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private boolean hasExceptionWinningComplete(String input, LottoService service) {
        try {
            int winningBonus = makeInt(input);
            bonus = new Bonus(winningBonus);
            service.generateWinning(main, bonus);
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

}
