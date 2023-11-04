package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public int getPurchaseAmount() {
        return inputValidator.checkPurchaseAmount(Console.readLine());
    }

    public List<Integer> getLottoNumber() {
        return inputValidator.checkLottoNumber(Console.readLine());
    }

    public int getBonusNumber() {
        return inputValidator.checkBonusNumber(Console.readLine());
    }

}
