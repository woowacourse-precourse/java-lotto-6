package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputUtil;
import lotto.view.validator.InputValidator;

import java.util.List;

import static java.lang.Integer.*;

public class InputView {

    private InputView() {

    }

    protected static Integer readPurchaseAmount() {
        String input;
        while(true) {
            input = Console.readLine();
            try {
                InputValidator.validatePurchaseAmountInput(input);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return parseInt(input);
    }

    protected static List<Integer> readLottoNumbers() {
        String input;
        while(true) {
            input = Console.readLine();
            try {
                InputValidator.validateLottoNumberInput(input);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return InputUtil.convertToList(input);
    }

    protected static Integer readBonusNumber() {
        String input;
        while(true) {
            input = Console.readLine();
            try {
                InputValidator.validateBonusNumberInput(input);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return parseInt(input);
    }
}
