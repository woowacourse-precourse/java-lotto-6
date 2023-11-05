package lotto.view;

import java.util.List;

public interface OutputView {
    void printLottoList(int lottoListNumber, List<String> lottoListString);

    void printWinningList(String winningList);

    void printProfitRate(String profitRate);
}
