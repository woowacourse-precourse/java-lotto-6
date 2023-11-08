package lotto.model;

public class Purchase {
    private static final int ONE_LOTTO_PRICE = 1000;

    private final int money;

    public Purchase(String money){
        validate(Integer.parseInt(money));
        this.money = Integer.parseInt(money);
    }

    private void validate(int money) {
        try {
            int moneyValue = Integer.parseInt(String.valueOf(money));
            if (moneyValue < ONE_LOTTO_PRICE) {
                throw new IllegalArgumentException("로또 구매는 1000원부터 가능합니다.");
            }
            if (moneyValue % ONE_LOTTO_PRICE != 0) {
                throw new IllegalArgumentException("1000원 단위로만 구입이 가능합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입 금액은 숫자만 입력해주세요.");
        }
    }

    public int countLottos(){
        return money / ONE_LOTTO_PRICE;
    }
    public int getLottos(){
        return this.money;
    }



}
