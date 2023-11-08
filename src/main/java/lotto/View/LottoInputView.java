package lotto.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoInputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String START_GAME_MSG = "구입금액을 입력해 주세요. ";
    private static final String WINNING_NUMBERS_MSG = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MSG = "보너스 번호를 입력해 주세요: ";
    private static final String INPUT_ERROR_MSG_BASIC = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String INPUT_ERROR_MSG_BONUS = "보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String INPUT_ERROR_MSG_FORMAT = "올바른 숫자를 입력해 주세요.";
    private static final String INPUT_ERROR_MSG_LENGTH = "6개의 번호를 입력하세요.";
    private static final String INPUT_ERROR_MSG_DUPLICATED = "로또 번호에 중복된 숫자가 있습니다.";


    public int getUserInput() {
        int userInput = 0;
        while (true) {
            try {
                System.out.println(START_GAME_MSG);
                userInput = Integer.parseInt(Console.readLine());
                break;
            } catch (NumberFormatException e) {
                displayError(INPUT_ERROR_MSG_FORMAT);
            }
        }
        return userInput;
    }

    public List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        while (winningNumbers.size() < 6) {
            try {
                System.out.println(WINNING_NUMBERS_MSG);
                String input = Console.readLine();
                String[] numberStrings = input.split(",");
                if (numberStrings.length != 6) {
                    displayError(INPUT_ERROR_MSG_LENGTH);
                    continue;
                }
                winningNumbers.clear();
                Set<Integer> uniqueNumbers = new HashSet<>(); // 중복 검사를 위한 Set
                for (String numberString : numberStrings) {
                    int number = Integer.parseInt(numberString);
                    if (number < 1 || number > 45) {
                        displayError(INPUT_ERROR_MSG_BASIC);
                        winningNumbers.clear();
                        break;
                    } else if (uniqueNumbers.contains(number)) { // 중복 검사
                        displayError(INPUT_ERROR_MSG_DUPLICATED);
                        winningNumbers.clear();
                        break;
                    } else {
                        winningNumbers.add(number);
                        uniqueNumbers.add(number); // 중복 검사용 Set에 추가
                    }
                }
            } catch (NumberFormatException e) {
                displayError(INPUT_ERROR_MSG_FORMAT);
            }
        }
        return winningNumbers;
    }

    public int getBonusNumber() {
        int bonusNumber = 0;
        while (true) {
            try {
                System.out.println(BONUS_NUMBER_MSG);
                bonusNumber = Integer.parseInt(Console.readLine());
                if (bonusNumber < 1 || bonusNumber > 45) {
                    displayError(INPUT_ERROR_MSG_BONUS);
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                displayError(INPUT_ERROR_MSG_FORMAT);
            }
        }
        return bonusNumber;
    }

    public void displayError(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }
}
