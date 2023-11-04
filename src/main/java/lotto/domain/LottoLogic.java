package lotto.domain;

public class LottoLogic {
    private final BigDecimal purchaseAmount;
    private final int bonusNumber;


    public LottoLogic(int purchaseAmount, int bonusNumber) {
    public LottoLogic(BigDecimal purchaseAmount, int bonusNumber) {
        this.purchaseAmount = purchaseAmount;
        this.bonusNumber = bonusNumber;
    }
}
