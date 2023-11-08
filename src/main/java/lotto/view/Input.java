package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputMessage;
import lotto.validation.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class Input {

    InputValidator inputValidator = new InputValidator();

    public int insertMoney() {
        System.out.println(InputMessage.INPUT_MONEY.getMessage());
        String inputValue = Console.readLine().trim();
        inputValidator.checkIsInputNumber(inputValue);
        int money = Integer.parseInt(inputValue);
        return money;
    }

    public List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        System.out.println(InputMessage.INPUT_WINNING_NUMBERS.getMessage());
        String inputValue = Console.readLine().trim();
        inputValidator.ensureCommaDelimiter(inputValue);
        String[] splitNumbers = inputValue.split(",");
        inputValidator.checkDuplicated(splitNumbers);
        inputValidator.checkNumbersLength(splitNumbers);
        inputValidator.isNumber(splitNumbers);
        for (String number : splitNumbers) {
            winningNumbers.add(Integer.parseInt(number));
        }
        inputValidator.checkNumbersRange(winningNumbers);
        return winningNumbers;
    }


    public int inputBonusNumber() {
        System.out.println(InputMessage.INPUT_BONUS_NUMBER.getMessage());
        String inputValue = Console.readLine().trim();
        inputValidator.checkIsBonusNumber(inputValue);
        int bonusNumber = Integer.parseInt(inputValue);
        inputValidator.checkLottoNumberRange(bonusNumber);
        return bonusNumber;

    }

}
