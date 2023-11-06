package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningLotto;
import lotto.validator.InputValidator;

import java.util.ArrayList;

public class InputView {
    private InputValidator inputValidator = new InputValidator();

    public PurchasePrice inputPrice() {
        String price = Console.readLine();
        inputValidator.checkInteger(price);
        return new PurchasePrice(Integer.parseInt(price));
    }

    public void inputBonusNumber(WinningLotto winningLotto) {
        String bonusNumber = Console.readLine();
        inputValidator.checkInteger(bonusNumber);
        winningLotto.setBonusLottoNum(Integer.parseInt(bonusNumber));
    }
}
