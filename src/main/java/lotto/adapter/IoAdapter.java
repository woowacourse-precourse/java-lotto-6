package lotto.adapter;

import java.util.List;
import lotto.domain.Statistics;
import lotto.domain.Wallet;

public interface IoAdapter {

    String inputStream();

    void printPurchaseLotto(Wallet wallet);

    void printStatistics(Statistics statistics);

    void printMessage(String message);
}
