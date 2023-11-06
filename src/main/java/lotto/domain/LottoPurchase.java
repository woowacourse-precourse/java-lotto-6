package lotto.domain;

public class LottoPurchase {
    private final static int MIN_AMOUNT = 0;
    private final static int AMOUNT_UNIT = 1000;
    private int money;
    private int count;

    private LottoPurchase(int money) {
        validateZeroOverMoney(money);
        validateOneThousandUnitsMoney(money);
        buyLottos(money);
    }

    public static LottoPurchase of(int money) {
        return new LottoPurchase(money);
    }

    public void buyLottos(int money) {
        this.count = money / 1000;
    }

    public int getCount() {
        return count;
    }

    public void validateZeroOverMoney(int money) {
        if (money <= MIN_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 금액을 0원 이상 입력해주세요.");
        }
    }

    public void validateOneThousandUnitsMoney(int money) {
        if (money % AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 금액을 1000원 단위로 입력해주세요.");
        }
    }
}
