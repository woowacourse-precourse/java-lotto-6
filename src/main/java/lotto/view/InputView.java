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
        return parseInt(Console.readLine());
    }

    protected List<Integer> readLottoNumbers() {
        String input = Console.readLine();
        InputValidator.validateLottoNumberInput(input);
        return InputUtil.convertToList(input);
    }
}
