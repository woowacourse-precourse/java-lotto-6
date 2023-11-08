package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.BonusNumberRequest;
import lotto.dto.PurchaseAmountRequest;
import lotto.dto.WinningNumberRequest;

public class InputView {

    private final InputMapper inputMapper;

    public InputView(InputMapper inputMapper) {
        this.inputMapper = inputMapper;
    }

    public PurchaseAmountRequest readPurchaseAmount() {
        return inputMapper.inputToPurchaseAmountRequest(read());
    }

    public WinningNumberRequest readWinningNumber() {
        return inputMapper.inputToWinningNumberRequest(read());
    }

    public BonusNumberRequest readBonusNumber() {
        return inputMapper.inputToBonusNumberRequest(read());
    }

    private String read() {
        return Console.readLine();
    }
}
