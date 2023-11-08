package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Domain.EntireMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        while (winningNumbers.size() < 6) {
            try {
                System.out.println(EntireMessage.WINNING_NUMBERS_MSG);
                String input = Console.readLine();
                String[] numberStrings = input.split(",");
                if (numberStrings.length != 6) {
                    EntireMessage.displayError(EntireMessage.ERROR_MSG_LENGTH);
                    continue;
                }
                winningNumbers.clear();
                Set<Integer> uniqueNumbers = new HashSet<>();
                for (String numberString : numberStrings) {
                    int number = Integer.parseInt(numberString);
                    if (number < 1 || number > 45) {
                        EntireMessage.displayError(EntireMessage.INPUT_ERROR_MSG_BASIC);
                        winningNumbers.clear();
                        break;
                    }
                    if (uniqueNumbers.contains(number)) {
                        EntireMessage.displayError(EntireMessage.ERROR_MSG_DUPLICATED);
                        winningNumbers.clear();
                        break;
                    }
                    winningNumbers.add(number);
                    uniqueNumbers.add(number);

                }
            } catch (NumberFormatException e) {
                EntireMessage.displayError(EntireMessage.INPUT_ERROR_MSG_FORMAT);
            }
        }
        return winningNumbers;
    }

    public int getBonusNumber() {
        int bonusNumber = 0;
        while (true) {
            try {
                System.out.println(EntireMessage.BONUS_NUMBER_MSG);
                bonusNumber = Integer.parseInt(Console.readLine());
                if (bonusNumber < 1 || bonusNumber > 45) {
                    EntireMessage.displayError(EntireMessage.INPUT_ERROR_MSG_BONUS);
                }
                break;
            } catch (NumberFormatException e) {
                EntireMessage.displayError(EntireMessage.INPUT_ERROR_MSG_FORMAT);
            }
        }
        return bonusNumber;
    }

}