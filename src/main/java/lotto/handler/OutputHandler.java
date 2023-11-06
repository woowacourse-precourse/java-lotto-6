package lotto.handler;

import lotto.domain.wrapper.Lotto;
import lotto.domain.wrapper.LottoResult;

import java.util.List;

public interface OutputHandler {

    public void printInputMoneyMessage();
    public void printBuyLottoList(List<Lotto> buyLottos);
    public void printInputWinningLottoMessage();
    public void printInputBonusLottoMessage();
    public void printLottoResult(LottoResult lottoResults);
    public void printProfit(LottoResult lottoResults);
}
