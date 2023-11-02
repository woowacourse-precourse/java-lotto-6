package lotto.adapter;

import java.util.List;
import lotto.domain.Statistics;
import lotto.domain.Wallet;
import lotto.vo.Lotto;

public interface IoAdapter {

    String inputStream();

    void printPurchaseLotto(List<Lotto> lottoBundle);

    void printStatistics(Statistics statistics);

    void printMessage(String message);
}
