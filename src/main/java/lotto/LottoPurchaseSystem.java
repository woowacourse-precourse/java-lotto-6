package lotto;

public class LottoPurchaseSystem {
    private int money;
    static int lottoAmount;

    public void setMoney(int money) {
        validateMoneyisNaturalNumber(money);
        this.money = money;
    }
    public int getMoney() {
        return money;
    }

    void calculateLottoAmount() {
        validateDevidedMoney(this.money);
        this.lottoAmount = this.money / 1000;
    }

    private void validateDevidedMoney(int money) {
        if(money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 1,000원 단위로 입력하세요");
        }
    }

    private void validateMoneyisNaturalNumber(int money) {
        if(money < 0) {
            throw new IllegalStateException("[ERROR] 로또 구매 금액은 자연수입니다");
        }
    }
}
