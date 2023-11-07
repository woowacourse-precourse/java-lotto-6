package lotto;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;

public class LottoResultChecker {
    HashMap<LottoRank, Integer> lottoResult;

    public LottoResultChecker() {
        this.lottoResult = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            this.lottoResult.put(lottoRank, 0);
        }
    }

    public void checkLotto(List<Lotto> lottos, WinningLotto drawnNumbers) {
        for (Lotto lotto : lottos) {
            LottoRank rank = LottoRank.getRank(lotto, drawnNumbers);
            if (null != rank) {
                Integer count = this.lottoResult.get(rank);
                this.lottoResult.put(rank, count + 1);
            }
        }
    }

    public void printTotalPrize() {
        for (LottoRank lottoRank : LottoRank.values()) {
            System.out.println(printPrize(lottoRank));
        }
    }

    public String printPrize(LottoRank lottoRank) {
        String commaPrize = NumberFormat.getInstance().format(lottoRank.getPrize());

        if (lottoRank.isCorrectBonus()) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개",
                    lottoRank.getCorrectCount(),
                    commaPrize,
                    this.lottoResult.get(lottoRank));
        }

        return String.format("%d개 일치 (%s원) - %d개",
                lottoRank.getCorrectCount(),
                commaPrize,
                this.lottoResult.get(lottoRank));
    }

    public void printProfit() {
    }
}
