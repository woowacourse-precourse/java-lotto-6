package lotto.domain;

/**
 * @author 민경수
 * @description lotto purchase amount
 * @since 2023.11.04
 **********************************************************************************************************************/
public class LottoPurchaseAmount {

    private int value;

    private LottoPurchaseAmount(int value) {
        this.value = value;
    }

    public static LottoPurchaseAmount valueOf(int amount) {
        // TODO 검증
        return new LottoPurchaseAmount(amount);
    }

    public boolean isOverLottoPrice() {
        return value >= Lotto.PRICE;
    }

    public void subtractOneLottoPrice() {
        value -= Lotto.PRICE;
    }
}