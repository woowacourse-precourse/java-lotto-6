package lotto;

public class Price {
    private final int price;

    public Price(int price) {
        validate(price);
        this.price = price;
    }

    private void validate(int price) {
        if((price % 1000) > 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.");
        }
    }

    public int countLotto(Price price){
        return price.price / 1000;
    }
}
