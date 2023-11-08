package lotto.controller;

import lotto.dto.request.BonusNumberRequest;
import lotto.dto.request.PurchaseRequest;
import lotto.dto.request.WinningLottoRequest;
import lotto.dto.response.LottoWinningStatsResponse;
import lotto.dto.response.PurchaseResponse;
import lotto.service.LottoService;

public class LottoController {
    private final static LottoService lottoService = new LottoService();

    public PurchaseResponse receiverMoneyInput(PurchaseRequest purchaseRequest){
        return lottoService.createLottoTickets(purchaseRequest);
    }

    public void receiverWinningLottoInput(WinningLottoRequest winningLottoRequest){
        lottoService.createWinningLotto(winningLottoRequest);
    }

    public void receiverBonusNumberInput(BonusNumberRequest bonusNumberRequest){
        lottoService.createBonusNumber(bonusNumberRequest);
    }

    public LottoWinningStatsResponse getLottoWinningStatsResponse() {
      return lottoService.getLottoWinningStats();
    }
}