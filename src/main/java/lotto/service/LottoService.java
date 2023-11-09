package lotto.service;

import java.util.Objects;
import lotto.domain.Money;
import lotto.domain.converter.LottoConverter;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.number.BonusNumber;
import lotto.domain.number.CompareLottoNumber;
import lotto.domain.result.TotalProfit;
import lotto.dto.request.BonusNumberRequest;
import lotto.dto.request.PurchaseRequest;
import lotto.dto.request.WinningLottoRequest;
import lotto.dto.response.LottoWinningStatsResponse;
import lotto.dto.response.PurchaseResponse;

public class LottoService {

    private final LottoConverter converter = new LottoConverter();
    private WinningLotto winningLotto;
    private LottoTicket lottoTicket;
    private BonusNumber bonusNumber;
    private Money money;

    public PurchaseResponse createLottoTickets(PurchaseRequest purchaseRequest) {
        if (Objects.equals(purchaseRequest.getMoney(), "")) {
            throw new IllegalArgumentException("[ERROR] 빈값이 입력되었습니다.");
        }
        money = converter.purchaseRequestConvertToMoney(purchaseRequest);
        var purchase = converter.moneyConvertToPurchase(money);
        lottoTicket = new LottoTicket(purchase);
        var tickets =
            converter.lottoTicketConvertToLottoNumberResponses(lottoTicket.getLottoTicket());

        return new PurchaseResponse(purchase.getPurchaseLotto(), tickets);
    }
    //purchase 자동 생성

    public void createWinningLotto(WinningLottoRequest winningLottoRequest) {
        if (Objects.equals(winningLottoRequest.getWinningLotto(), "")) {
            throw new IllegalArgumentException("[ERROR] 빈값이 입력되었습니다.");
        }
        winningLotto = converter.winningLottoRequestConvertToWinningLotto(winningLottoRequest);
    }

    public void createBonusNumber(BonusNumberRequest bonusNumberRequest) {
        if (Objects.equals(bonusNumberRequest.getBonusNumber(), "")) {
            throw new IllegalArgumentException("[ERROR] 빈값이 입력되었습니다.");
        }
        bonusNumber = new BonusNumber(bonusNumberRequest, winningLotto);
    }

    public LottoWinningStatsResponse getLottoWinningStats() {
        var compare = new CompareLottoNumber(lottoTicket, winningLotto, bonusNumber);
        var totalProfit = new TotalProfit(compare.getDeterminePrizeMap(), money);

        return converter.convertToLottoWinningStatsResponse(
            converter.convertToWinningStatsResponse(compare),
            totalProfit.getTotalProfit()
        );
    }
}