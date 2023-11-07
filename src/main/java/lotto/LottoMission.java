package lotto;

import static lotto.view.Prompt.WAIT_FOR_BONUS_NUMBER;
import static lotto.view.Prompt.WAIT_FOR_PURCHASE_AMOUNT;
import static lotto.view.Prompt.WAIT_FOR_WINNING_NUMBERS;

import lotto.common.Mission;
import lotto.controller.LottoMissionController;
import lotto.io.ConsoleUserInterface;
import lotto.io.UserInputReader;
import lotto.view.ConsoleView;

public class LottoMission implements Mission {

    private ConsoleView view;
    private LottoMissionController controller;

    public LottoMission() {
        controller = new LottoMissionController();
    }

    @Override
    public void run() throws IllegalArgumentException {
        ConsoleUserInterface.prompt(WAIT_FOR_PURCHASE_AMOUNT);
        view = controller.purchaseRequiredAmount(UserInputReader.readPureNumber());
        ConsoleUserInterface.printView(view);

        ConsoleUserInterface.prompt((WAIT_FOR_WINNING_NUMBERS));
        controller.setWinningNumbers(UserInputReader.readMultiplePureNumbers());

        ConsoleUserInterface.prompt(WAIT_FOR_BONUS_NUMBER);
        controller.setBonusNumber(UserInputReader.readPureNumber());
        view = controller.draw();
        ConsoleUserInterface.printView(view);
    }
}
