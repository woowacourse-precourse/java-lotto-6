package lotto.io;

import java.util.Map;
import lotto.domain.LottoReceipt;
import lotto.domain.Rank;

public interface LottoOutput {
    void printAskingMoney();

    void printLottoReceipt(LottoReceipt receipt);

    void printAskingWinningNumbers();

    void printAskingBonusNumber();

    void printResults(Map<Rank, Integer> result);

    void printProfitAsPercentage(Map<Rank, Integer> result);
}
