package lotto.output;

import lotto.domain.Lotto;
import lotto.domain.WinningInformation;

public interface OutputSender {
    void send(String output);

    void outputPurchaseMoneyInputMessage();

    void outputWinningNumberInputMessage();

    void outputBonusNumberInputMessage();

    void outputWinningInformation(WinningInformation winningInformation);

    void outputNewLine();

    void outputNumberOfLottos(int numberOfLottos);

    void outputLotto(Lotto lotto);

    void outputError(String errorMessage);

}
