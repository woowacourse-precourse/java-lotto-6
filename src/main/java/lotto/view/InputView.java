package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Dangchum;
import lotto.util.Constant;
import lotto.util.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    InputValidator inputValidator = new InputValidator();

    public int userInputMoney() {
        OutputView.printLottoStartMessage();
        boolean validInput = false;
        String userInput = "";
        while (!validInput) {
            userInput = Console.readLine();
            if (inputValidator.isValidInputMoney(userInput)) {
                validInput = true;
            }
        }
        return Integer.parseInt(userInput);
    }

    public List<Integer> userInputDangchum() {
        OutputView.printInputDangchumMessage();
        boolean validInput = false;
        String[] splitUserInput = {};
        List<Integer> inputDangchum = new ArrayList<>();

        while (!validInput) {
            String userInput = Console.readLine();
            splitUserInput = userInput.split(",");
            if (inputValidator.isValidInteger(splitUserInput)) {
                validInput = true;
            }
            try {
                inputValidator.isNotDuplicated(splitUserInput);
            } catch (IllegalArgumentException e) {
                validInput = false;
            }
        }
        inputDangchum = string2ListInt(splitUserInput);
        return inputDangchum;
    }

    public int userInputBonus(List<Integer> inputDangchum) {
        OutputView.printInputBonusMessage();
        boolean validInput = false;

    }

    public List<Integer> string2ListInt(String[] splitUserInput) {
        List<Integer> inputDangchum = new ArrayList<>();
        for (String sNum : splitUserInput) {
            int iNum = Integer.parseInt(sNum);
            if (!inputDangchum.contains(iNum)) {
                inputDangchum.add(iNum);
            }
        }
        return inputDangchum;
    }

}
