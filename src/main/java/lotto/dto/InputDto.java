package lotto.dto;


import lotto.model.domain.Lottos;

public class InputDto {

    private int lottoPurchaseAmount;
    private Lottos lottos;

    public int getLottoPurchaseAmount() {
        return lottoPurchaseAmount;
    }

    public void setLottoPurchaseAmount(String lottoPurchaseAmount) {
        this.lottoPurchaseAmount = Integer.parseInt(lottoPurchaseAmount);
    }

    public Lottos getLottos() {
        return lottos;
    }

    public void setLottos(Lottos lottos) {
        this.lottos = lottos;
    }
}
