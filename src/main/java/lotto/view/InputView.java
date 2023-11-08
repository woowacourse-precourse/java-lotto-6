package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Constant;
import lotto.util.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    InputValidator inputValidator = new InputValidator();

    public int userInputMoney() {
        boolean validInput = false;
        String userInput = "";
        while (!validInput) {
            OutputView.printLottoStartMessage();
            userInput = Console.readLine();
            if (inputValidator.isValidInputMoney(userInput)) {
                validInput = true;
            }
        }
        return Integer.parseInt(userInput);
    }

    public List<Integer> userInputDangchum() {
        boolean validInput = false;
        String[] splitUserInput = {};
        List<Integer> inputDangchum = new ArrayList<>();

        while (!validInput || splitUserInput.length != Constant.DANGCHUM_NUM_CNT) {
            OutputView.printInputDangchumMessage();
            String userInput = Console.readLine();
            splitUserInput = userInput.split(",");
            if (inputValidator.isValidInteger(splitUserInput)) {
                validInput = true;
            }
            if (splitUserInput.length > Constant.DANGCHUM_NUM_CNT) {
                OutputView.printNumNotSixErrorMessage();
                continue;
            }
            // 6개 이상 들어왔을 때, 오류를 catch로 잡아서 에러 메세지 보여줘야하나??
            try {
                inputValidator.isNotDuplicated(splitUserInput);
            } catch (IllegalArgumentException e) {
                OutputView.printDuplicateErrorMessage();
                validInput = false;
            } catch (IllegalStateException e) {
                OutputView.printMessage(e.getMessage());
                validInput = false;
            }

        }
        inputDangchum = string2ListInt(splitUserInput);
        return inputDangchum;
    }

    public int userInputBonus(List<Integer> dangchum) {
        boolean validInput = false;
        String[] splitUserInput = {};

        while (!validInput) {
            OutputView.printInputBonusMessage();
            String userInput = Console.readLine();
            splitUserInput = userInput.split(",");
            if (inputValidator.isValidInteger(splitUserInput)) {
                validInput = true;
            }
            try {
                inputValidator.isNotDuplicated(splitUserInput);
            } catch (IllegalStateException e) {
                OutputView.printMessage(e.getMessage());
                validInput = false;
            }
            if (!checkBonus(dangchum, Integer.parseInt(splitUserInput[0]))) {
                OutputView.printBonusInDangchumErrorMessage();
                validInput = false;
            }
        }
        return Integer.parseInt(splitUserInput[0]);
    }

    public boolean checkBonus(List<Integer> dangchum, int SplitUserInput0) {
        if (dangchum.contains(SplitUserInput0)) {
            return false;
        }
        return true;
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
