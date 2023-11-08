package lotto;

public class PriceValidation {

    private long price;

    public PriceValidation(long total_lotto_price) {
        price_validate(total_lotto_price);
        this.price = total_lotto_price;
    }


    private void price_validate(long price) {
        if( price % 1000 != 0 ) {
            throw new IllegalArgumentException("[Error] 로또 금액을 1000원 단위로 입력해야 합니다.");
        }
    }

    public long createCount() {
        return price / 1000;
    }
}
