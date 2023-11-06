package lotto.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

public final class ConsoleLottoInputView implements LottoInputView {
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
