package lotto.service;

import lotto.domain.Buyer;
import lotto.domain.WiningRank;

public class ProfitsService {

    private int buyerPurchaseAmount;
    private int buyerProfits;
    private double rateOfReturn;

    public ProfitsService(Buyer buyer) {
        this.buyerPurchaseAmount = buyer.getPurchaseAmount();
    }

    public int getBuyerProfits() {
        return buyerProfits;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    public void calculateRateOfReturn(LottoService lottoService) {
        calculateBuyerProfits(lottoService);
        rateOfReturn = (double) buyerProfits / buyerPurchaseAmount * 100;
    }

    private void calculateBuyerProfits(LottoService lottoService) {
        for (WiningRank rank : lottoService.getWiningDetails().keySet()) {
            int winingAmount = rank.getWiningAmount();
            int matchCount = lottoService.getWiningDetails().get(rank);
            buyerProfits += winingAmount * matchCount;
        }
    }
}
