package lotto.controller.action;

import lotto.domain.model.Bonus;
import lotto.domain.model.Lotto;
import lotto.domain.service.LottoService;
import lotto.ui.input.InputView;
import lotto.ui.output.OutputView;

import java.util.List;

import static lotto.controller.util.Conversion.makeInt;
import static lotto.controller.util.Conversion.makeIntegerList;

public class WinningAction {

    private Lotto main;
    private Bonus bonus;

    public void processWinningMain(String message) {
        String input;
        do {
            OutputView.printMessage(message);
            input = InputView.input();
        } while (runMain(input));
    }

    public void processWinningComplete(String message, LottoService service) {
        String input;
        do {
            OutputView.printMessage(message);
            input = InputView.input();
        } while (runComplete(input, service));
    }

    public boolean runMain(String input) {
        try {
            List<Integer> winningMain = makeIntegerList(input);
            main =  new Lotto(winningMain);
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    public boolean runComplete(String input, LottoService service) {
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
