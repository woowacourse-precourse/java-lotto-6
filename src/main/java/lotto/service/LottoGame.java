package lotto.service;

import java.text.DecimalFormat;
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

        rateOfReturn = ((double) totalPrize) / input * 100;

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

        for (WinnerType winnerType : WinnerType.values()) {
            if (winnerType.equals(WinnerType.NOTHING)) {
                continue;
            }
            System.out.printf("%s%d개%n", winnerType.message(), winner.getOrDefault(winnerType, 0));
        }

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        ConsoleMessage.RATE_OF_RETURN.print(decimalFormat.format(getRateOfReturn()));
    }
}
