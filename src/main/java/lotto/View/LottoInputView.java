package lotto.View;

import camp.nextstep.edu.missionutils.Console;

import lotto.Domain.ErrorMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoInputView {


    public int getUserInput() {
        int userInput = 0;
        while (true) {
            try {
                System.out.println(ErrorMessage.START_GAME_MSG);
                userInput = Integer.parseInt(Console.readLine());
                break;
            } catch (NumberFormatException e) {
                ErrorMessage.displayError(ErrorMessage.INPUT_ERROR_MSG_FORMAT);
            }
        }
        return userInput;
    }

    public List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        while (winningNumbers.size() < 6) {
            try {
                System.out.println(ErrorMessage.WINNING_NUMBERS_MSG);
                String input = Console.readLine();
                String[] numberStrings = input.split(",");
                if (numberStrings.length != 6) {
                    ErrorMessage.displayError(ErrorMessage.ERROR_MSG_LENGTH);
                    continue;
                }
                winningNumbers.clear();
                Set<Integer> uniqueNumbers = new HashSet<>(); // 중복 검사를 위한 Set
                for (String numberString : numberStrings) {
                    int number = Integer.parseInt(numberString);
                    if (number < 1 || number > 45) {
                        ErrorMessage.displayError(ErrorMessage.INPUT_ERROR_MSG_BASIC);
                        winningNumbers.clear();
                        break;
                    } else if (uniqueNumbers.contains(number)) { // 중복 검사
                        ErrorMessage.displayError(ErrorMessage.ERROR_MSG_DUPLICATED);
                        winningNumbers.clear();
                        break;
                    } else {
                        winningNumbers.add(number);
                        uniqueNumbers.add(number); // 중복 검사용 Set에 추가
                    }
                }
            } catch (NumberFormatException e) {
                ErrorMessage.displayError(ErrorMessage.INPUT_ERROR_MSG_FORMAT);
            }
        }
        return winningNumbers;
    }

    public int getBonusNumber() {
        int bonusNumber = 0;
        while (true) {
            try {
                System.out.println(ErrorMessage.BONUS_NUMBER_MSG);
                bonusNumber = Integer.parseInt(Console.readLine());
                if (bonusNumber < 1 || bonusNumber > 45) {
                    ErrorMessage.displayError(ErrorMessage.INPUT_ERROR_MSG_BONUS);
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                ErrorMessage.displayError(ErrorMessage.INPUT_ERROR_MSG_FORMAT);
            }
        }
        return bonusNumber;
    }


}
