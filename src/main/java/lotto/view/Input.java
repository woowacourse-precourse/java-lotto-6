package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.Controller;
import lotto.validation.InputValidator;

import java.util.*;

public class Input {

    InputValidator inputValidator = new InputValidator();

    public int insertMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputValue = Console.readLine().trim();
        inputValidator.checkIsInputNumber(inputValue);
        int money = Integer.parseInt(inputValue);
        return money;
    }

    public List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
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
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputValue = Console.readLine().trim();
        inputValidator.checkIsBonusNumber(inputValue);
        int bonusNumber = Integer.parseInt(inputValue);
        inputValidator.checkLottoNumberRange(bonusNumber);
        return bonusNumber;

    }

}
