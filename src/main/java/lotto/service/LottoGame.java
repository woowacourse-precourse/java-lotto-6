package lotto.service;

import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import lotto.constant.ConsoleMessage;
import lotto.constant.WinnerType;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.repository.LottoStore;

public class LottoGame {
    private final LottoStore lottoStore;
    private final WinningNumber winningNumber;
    private final Map<WinnerType, Integer> winner;

    public LottoGame(LottoStore lottoStore, WinningNumber winningNumber) {
        this.lottoStore = lottoStore;
        this.winningNumber = winningNumber;
        this.winner = new EnumMap<>(WinnerType.class);
        guessWinner();
    }

    private void guessWinner() {
        for (Lotto lotto : lottoStore.getLottos()) {
            WinnerType winnerType = winningNumber.calcWinner(lotto);
            winner.put(winnerType, winner.getOrDefault(winnerType, 1));
        }
    }

    private double getRateOfReturn() {
        double rateOfReturn = 0;

        int input = lottoStore.getMoney();
        long totalPrize = getTotalPrize();

        rateOfReturn = ((double) totalPrize) / input;

        return rateOfReturn;
    }

    private long getTotalPrize() {
        long totalPrize = 0;

        for (Entry<WinnerType, Integer> entry : winner.entrySet()) {
            totalPrize += ((long) entry.getKey().getPrize()) * entry.getValue();
        }

        return totalPrize;
    }

    public void printResult() {
        ConsoleMessage.WINNING_STATUS.print();

        for (Entry<WinnerType, Integer> entry : winner.entrySet()) {
            if (entry.getKey().equals(WinnerType.NOTHING)) {
                continue;
            }
            System.out.printf("%s%d개%n", entry.getKey().message(), entry.getValue());
        }

        ConsoleMessage.RATE_OF_RETURN.print(getRateOfReturn());
    }
}
