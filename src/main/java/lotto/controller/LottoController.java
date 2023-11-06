package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Player;
import lotto.validation.LottoValidation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private Player player;

    public void play() {
        prepareLotto();
    }

    private void prepareLotto() {
        try {
            player = new Player(getAmount());
            OutputView.printAmount(player.convertToUnit());
            OutputView.printLotteries(player);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e);
            prepareLotto();
        }
    }

    private int getAmount() {
        try {
            InputView.inputAmount();
            String input = Console.readLine();
            LottoValidation.validateIsNumber(input);
            return convertStringToInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return getAmount();
        }
    }

    private int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }
}
