package lotto.dto.response;

import java.util.List;

public class PurchaseResponse {

    private final int purchaseCount;
    private final List<LottoNumbersResponse> lottoTicket;

    public PurchaseResponse(int purchaseCount, List<LottoNumbersResponse> lottoTicket) {
        this.purchaseCount = purchaseCount;
        this.lottoTicket = lottoTicket;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public List<LottoNumbersResponse> getLottoTicket() {
        return lottoTicket;
    }
}