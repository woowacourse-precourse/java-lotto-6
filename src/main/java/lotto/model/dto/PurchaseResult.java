package lotto.model.dto;

import lotto.model.LottoPaper;

import java.util.List;

public class PurchaseResult {
    private int purchaseAmount;
    private List<LottoPaper> purchasedLottoPapers;

    public PurchaseResult(int purchaseAmount, List<LottoPaper> purchasedLottoPapers) {
        this.purchaseAmount = purchaseAmount;
        this.purchasedLottoPapers = purchasedLottoPapers;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<LottoPaper> getPurchasedLottoPapers() {
        return purchasedLottoPapers;
    }
}

