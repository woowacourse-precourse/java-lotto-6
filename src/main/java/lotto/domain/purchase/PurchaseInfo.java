package lotto.domain.purchase;

public record PurchaseInfo(
        PurchasePrice purchasePrice,
        PurchaseAmount purchaseAmount,
        PurchaseLottos purchaseLottos
) {

}
