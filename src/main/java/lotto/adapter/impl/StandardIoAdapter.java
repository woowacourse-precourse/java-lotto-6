package lotto.adapter.impl;

import camp.nextstep.edu.missionutils.Console;
import lotto.adapter.IoAdapter;
import lotto.domain.Statistics;
import lotto.domain.Wallet;

public class StandardIoAdapter implements IoAdapter {

    @Override
    public String inputStream() {
        return Console.readLine();
    }

    @Override
    public void printPurchaseLotto(Wallet wallet) {
    }

    @Override
    public void printStatistics(Statistics statistics) {

    }

    @Override
    public void printMessage(String message) {

    }
}
