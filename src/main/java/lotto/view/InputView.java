package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputUtil;
import lotto.view.validator.InputValidator;

import java.util.List;

import static java.lang.Integer.*;

public class InputView {

    private InputView() {

    }

    protected Integer readPurchaseAmount() {
        String input = Console.readLine();
        InputValidator.validatePurchaseAmountInput(input);
        return parseInt(input);
    }

    protected List<Integer> readLottoNumbers() {
        String input = Console.readLine();
        InputValidator.validateLottoNumberInput(input);
        return InputUtil.convertToList(input);
    }

    protected Integer readBonusNumber() {
        String input = Console.readLine();
        InputValidator.validateBonusNumberInput(input);
        return parseInt(input);
    }
}
