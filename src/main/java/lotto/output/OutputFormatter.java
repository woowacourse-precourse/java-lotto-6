package lotto.output;

import lotto.domain.Lotto;
import lotto.domain.WinningInformation;

public interface OutputFormatter {
    String formatPurchaseMoneyInputMessage();

    String formatWinningNumberInputMessage();

    String formatBonusNumberInputMessage();

    String formatNumberOfLottos(int numberOfLottos);

    String formatLotto(Lotto lotto);

    String formatWinningInformation(WinningInformation winningInformation);

    String formatProfitability(double profitability);

    String formatError(String errorMessage);
}
