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
        player = new Player(getAmount());
        OutputView.printAmount(player.convertToUnit());
        OutputView.printLottos(player);
    }

    private int getAmount() {
        InputView.inputAmount();
        String input = Console.readLine();
        LottoValidation.validateIsNumber(input);
        return convertStringToInt(input);
    }

    private int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }
}
