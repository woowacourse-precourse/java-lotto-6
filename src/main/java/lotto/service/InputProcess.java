package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.InputView;

import java.util.List;
public class InputProcess {

    InputView inputView = new InputView();

    public String getPurchaseAmount() {
        inputView.inputPurchaseAmount();
        return Console.readLine();
    }

    public List<String> getWinningNumber() {
        inputView.inputWinningNumber();
        return List.of(Console.readLine().split(","));
    }

    public String getBonusNumber() {
        inputView.inputBonusNumber();
        return Console.readLine();
    }
}
