package lotto.input;

import static lotto.exception.ExceptionMessage.WRONG_BONUS_NUMBER_SIZE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class LottoBonusNumberInputManager {
    private LottoBonusNumberInputManager() {
    }

    public static int fromConsole(List<Integer> answerNumbers) {
        String userInput = Console.readLine();
        return fromString(userInput, answerNumbers);
    }

    static int fromString(String input, List<Integer> answerNumbers) {
        int bonusNumber = convertInputToLottoNumber(input);
        return bonusNumber;
    }

    private static int convertInputToLottoNumber(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_BONUS_NUMBER_SIZE);
        }
        validateLottoNumberSize(number);
        return number;
    }

    private static void validateLottoNumberSize(int lottoNumber) {
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException(WRONG_BONUS_NUMBER_SIZE);
        }
    }
}
