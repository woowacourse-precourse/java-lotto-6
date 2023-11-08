package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Domain.EntireMessage;

public class LottoInputView {
    public int getUserInput() {
        int userInput = 0;
        while (true) {
            try {
                System.out.println(EntireMessage.START_GAME_MSG);
                userInput = Integer.parseInt(Console.readLine());
                break;
            } catch (NumberFormatException e) {
                EntireMessage.displayError(EntireMessage.INPUT_ERROR_MSG_FORMAT);
            }
        }
        return userInput;
    }

    public int getBonusNumber() {
        while (true) {
            try {
                System.out.println(EntireMessage.BONUS_NUMBER_MSG);
                int bonusNumber = Integer.parseInt(Console.readLine());
                if (bonusNumber >= 1 & bonusNumber <= 45) {
                    return bonusNumber;
                }
                EntireMessage.displayError(EntireMessage.INPUT_ERROR_MSG_BONUS);
            } catch (NumberFormatException e) {
                EntireMessage.displayError(EntireMessage.INPUT_ERROR_MSG_FORMAT);
            }
        }
    }
}
