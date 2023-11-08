package lotto.service;

import lotto.constant.ConsoleMessage;
import lotto.constant.LottoRank;
import lotto.model.Lotto;
import lotto.model.LottoStore;
import lotto.model.WinningLottoNumbers;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.Map;

public class LottoGameService {

    private LottoStore lottoStore;
    private WinningLottoNumbers winningLottoNumbers;
    private Map<LottoRank, Integer> winner;

    public LottoGameService(LottoStore lottoStore, WinningLottoNumbers winningLottoNumbers) {
        this.lottoStore = lottoStore;
        this.winningLottoNumbers = winningLottoNumbers;
        this.winner = new EnumMap<>(LottoRank.class);
        guessWinner();
    }
    private void guessWinner() {
        for (Lotto lotto : lottoStore.getLottos()) {
            LottoRank lottoRank = winningLottoNumbers.calcWinner(lotto);
            winner.put(lottoRank, winner.getOrDefault(lottoRank, 1));
        }
    }

    private double getRateOfReturn() {
        int input = lottoStore.getMoney();
        long totalPrize = getTotalPrize();
        return ((double) totalPrize) / input * 100;
    }

    private long getTotalPrize() {
        long totalPrize = 0;

        for (Map.Entry<LottoRank, Integer> entry : winner.entrySet()) {
            totalPrize += ((long) entry.getKey().getPrize()) * entry.getValue();
        }

        return totalPrize;
    }

    public void printResult() {
        ConsoleMessage.WINNING_STATUS.print();

        for (LottoRank winnerType : LottoRank.values()) {
            if (winnerType.equals(LottoRank.NOTHING)) {
                continue;
            }
            System.out.printf("%s%d개%n", winnerType.message(), winner.getOrDefault(winnerType, 0));
        }

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        ConsoleMessage.RATE_OF_RETURN.print(decimalFormat.format(getRateOfReturn()));
    }

}
