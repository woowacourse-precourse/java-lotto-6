package view;

import static constants.ConstantNumbersManager.NOTHING;
import static constants.ConstantNumbersManager.VARIABLE_RESET;

import camp.nextstep.edu.missionutils.Console;
import utility.UserInputException;

public class InputView {
    UserInputException userInputException = new UserInputException();

    public int lottoPriceInput() {
        int input = VARIABLE_RESET;
        while (input == NOTHING) {
            try {
                input = Integer.parseInt(Console.readLine());
                userInputException.lottoPriceValidate(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 구입시 천원 단위의 숫자가 입력되어야 합니다.");
            }
        }
        return input;
    }

    public String lottoWinningNumberInput() {
        String input = null;
        while (input == null) {
            try {
                input = Console.readLine();
                userInputException.winningNumberValidate(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 당첨 번호는 중복 없는 6자리여야 하며, 6개의 숫자여야 합니다.");
            }
        }
        return input;
    }

    public int bonusNumberInput() {
        int input = VARIABLE_RESET;
        while (input == NOTHING) {
            try {
                input = Integer.parseInt(Console.readLine());
                userInputException.bonusNumberValidate(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 보너스 번호는 1~45 내의 숫자입니다.");
            }
        }
        return input;
    }
}
