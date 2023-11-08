package lotto.output;

import lotto.domain.LottoGrade;
import lotto.domain.LottoTicket;

import java.util.Map;

public interface LottoGameViewOutputPort {
    void printLottoCount(int lottoBoughtCount);
    void printGeneratedLottoList(LottoTicket lottoTicket);
    void printLottoResult(Map<LottoGrade, Integer> lottoStatistics);
    void printLottoProfitRate(String lottoProfit);
}
