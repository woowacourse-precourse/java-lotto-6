package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleLottoInputView implements LottoInputView {
    @Override
    public String inputPurchaseAmount() {
        return readLine();
    }

    @Override
    public String inputWinningNumber() {
        return readLine();
    }

    @Override
    public String inputBonusNumber() {
        return readLine();
    }
}
