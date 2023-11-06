package view;

import static config.OutputMessage.*;
import static exception.InputException.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

import controller.GameController;

import domain.Lotto;

public class InputView {

    private static final String SPRIT_REGEX = ",";
    private final GameController gameController;

    public InputView(GameController gameController) {
        this.gameController = gameController;
    }

    public void inputPayment() {
        System.out.println(DEPOSIT.getMessage());
        try {
            gameController.lottoAdd(validatePayUnit(validateInteger(Console.readLine())));
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            inputPayment();
        }
    }

    public void inputWinNumber() {
        System.out.println(WIN_NUMBER.getMessage());
        try {
            String[] winNumbers = Console.readLine().split(SPRIT_REGEX);
            gameController.winningLottoAdd(new Lotto(makeWinNumber(winNumbers)));
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            inputWinNumber();
        }
    }

    private List<Integer> makeWinNumber(String[] winNumbers) {
        List<Integer> winNumber = new ArrayList<>();
        for (String number : winNumbers) {
            winNumber.add(validateRange(validateInteger(number)));
        }
        return winNumber;
    }

    public void inputBonusNumber() {
        System.out.println(BONUS_NUMBER.getMessage());
        try {
            gameController.bonusLottoAdd(validateRange(validateInteger(Console.readLine())));
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            inputBonusNumber();
        }
    }

}
