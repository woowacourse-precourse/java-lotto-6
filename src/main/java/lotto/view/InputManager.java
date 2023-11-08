package lotto.view;

import lotto.Validation;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputManager {
    private static InputManager inputManager;

    private InputManager() {

    }

    public static InputManager getInstance() {
        if (inputManager == null) {
            inputManager = new InputManager();
        }
        return inputManager;
    }

    public int getPurchaseAmount() {
        String data = readLine();
        while (true) {
            try {
                Validation.validPurchaseMoney(data);
                return Integer.parseInt(data) / 1000;
            }
            catch (NumberFormatException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
            data = readLine();
        }
    }

    public List<Integer> getWinningNumbers() {
        String data = readLine();
        while (true) {
            try {
                Validation.validWinningNumbers(data);
                return splitNumbers(data);
            }
            catch (NumberFormatException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
            data = readLine();
        }
    }
    public List<Integer> splitNumbers(String data) {
        String[] splitNumbers = data.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : splitNumbers) {
            winningNumbers.add(Integer.parseInt(number));
        }
        return winningNumbers;
    }

    public int getBonusNumber() {
        String data = readLine();
        while (true) {
            try {
                Validation.validBonusNumber(data);
                return Integer.parseInt(data);
            }
            catch (NumberFormatException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
            data = readLine();
        }
    }
}
