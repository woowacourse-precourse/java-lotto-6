package lotto.output;

import lotto.common.LottoException;
import lotto.domain.LottoGrade;
import lotto.domain.LottoTicket;

import java.util.Map;

public interface LottoGameViewOutputPort {
    void printExceptionMessage(LottoException e);
    void printLottoCount(int lottoCount);
    void printGeneratedLottoList(LottoTicket lottoTicket);
    void printLottoResult(Map<LottoGrade, Integer> lottoStatistics);
    void printLottoProfitRate(String lottoProfit);
}
