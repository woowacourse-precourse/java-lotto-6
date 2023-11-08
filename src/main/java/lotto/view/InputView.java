package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Validation.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private InputValidator validator;

    public InputView(InputValidator validator) {
        this.validator = validator;
    }

    public int readPurchaseMoney() {
        String input = Console.readLine();
        validator.checkIsNotBlank(input);
        validator.checkCanParseInt(input);
        return Integer.parseInt(input);
    }

    public List<Integer> readWinningNumbers() {
        String input = Console.readLine();
        List<Integer> numberList = new ArrayList<>();
        String[] splitInput = input.split(",");
        for (String singleInput : splitInput) {
            validator.checkIsNotBlank(singleInput);
            validator.checkCanParseInt(singleInput);
            int number = Integer.parseInt(singleInput);
            numberList.add(number);
        }
        return numberList;
    }

    public int readBonusNumber() {
        String input = Console.readLine();
        validator.checkIsNotBlank(input);
        validator.checkCanParseInt(input);
        return Integer.parseInt(input);
    }
}
