package lotto.handler;

import lotto.domain.wrapper.Lotto;

import java.util.List;

public interface OutputHandler {

    public void printInputMoneyMessage();
    public void printBuyLottoList(List<Lotto> buyLottos);
    public void printInputWinningLottoMessage();
    public void printInputBonusLottoMessage();
    public void printLottoResult();
    public void printProfit();
}
