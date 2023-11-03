package view;

import static exception.InputException.*;

import camp.nextstep.edu.missionutils.Console;

import config.OutputMessage;

import controller.GameController;
import domain.Lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {

    private final GameController gameController;

    public InputView(GameController gameController) {
        this.gameController = gameController;
    }

    public void inputPayment() {
        System.out.println(OutputMessage.DEPOSIT.getMessage());
        try {
            gameController.lottoAdd(validatePayUnit(validateInteger(Console.readLine())));
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            inputPayment();
        }
    }

    public void inputWinNumber() {
        System.out.println(OutputMessage.WIN_NUMBER.getMessage());
        try {
            String[] winNumbers = Console.readLine().split(",");
            gameController.winningLottoAdd(new Lotto(makeWinNumber(winNumbers)));
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            inputWinNumber();
        }
    }

    private List<Integer> makeWinNumber(String[] winNumbers) {
        Set<Integer> winNumber = new HashSet<>();
        for(String number : winNumbers) {
            winNumber.add(validateRange(validateInteger(number)));
        }
        return new ArrayList<>(winNumber);
    }

    public void inputBonusNumber() {
        System.out.println(OutputMessage.BONUS_NUMBER.getMessage());
        try {
            gameController.BonusLottoAdd(validateRange(validateInteger(Console.readLine())));
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            inputBonusNumber();
        }
    }

}
