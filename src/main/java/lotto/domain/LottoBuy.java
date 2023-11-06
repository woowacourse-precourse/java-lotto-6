package lotto.domain;

public class LottoBuy {
    private Integer money;
    private Integer quantity;
    private static int MONEY_UNIT = 1000;

    private static final String LOTTO_MONEY_UNIT_ERROR_MESSAGE = "[ERROR] 로또 구입 금액 입력은 1,000원 단위로 입력해야합니다.";

    public LottoBuy(Integer money){
        validate(money);
        this.money = money;
    }

    public Integer getMoney() {
        return this.money;
    }

    public Integer getQuantity(){
        return this.quantity = money / MONEY_UNIT;
    }

    private void validate(Integer money) {
        if(money % MONEY_UNIT != 0){
            throw new IllegalArgumentException(LOTTO_MONEY_UNIT_ERROR_MESSAGE);
        }
    }
}
