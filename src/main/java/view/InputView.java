package view;

import camp.nextstep.edu.missionutils.Console;
import validation.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static final String INPUT_MONEY_PROMPT = "구입금액을 입력해 주세요.";
    public static final String WINIING_NUMBER_PROMPT = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    public static int inputMoney() {
        System.out.println(INPUT_MONEY_PROMPT);
        String lottoMoney = Console.readLine();
        return validateInputMoney(lottoMoney);
    }

    private static int validateInputMoney(String lottoMoney) {
        try {
            InputValidator.validInputMoney(lottoMoney);
            return Integer.parseInt(lottoMoney);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] "+e.getMessage());
            return inputMoney();
        }
    }

    public static List<Integer> getWinningNumber() {
        System.out.println(WINIING_NUMBER_PROMPT);
        String inputWinningNumber = Console.readLine();
        List<Integer> winningNumber = splittedWinningNumber(inputWinningNumber);
        return validateWinningNumber(winningNumber);
    }

    private static List<Integer> validateWinningNumber(List<Integer> winningNumber) {
        try {
            InputValidator.validWinningNumber(winningNumber);
            return winningNumber;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return getWinningNumber();
        }
    }

    public static void getBonusNumber(List<Integer> winningNumber) {
        System.out.println(BONUS_NUMBER_PROMPT);
        String bonusNumber = Console.readLine();
        validateBonusNumber(bonusNumber, winningNumber);
    }

    private static void validateBonusNumber(String bonusNumber, List<Integer> winningNumber) {
        try {
            InputValidator.validBonusNumber(bonusNumber, winningNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            getBonusNumber(winningNumber);
        }
    }

    public static List<Integer> splittedWinningNumber(String input) {
        String[] splittedNumber = input.trim().split(",");
        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < splittedNumber.length; index++) {
            result.add(Integer.parseInt(splittedNumber[index]));
        }
        return result;
    }
}