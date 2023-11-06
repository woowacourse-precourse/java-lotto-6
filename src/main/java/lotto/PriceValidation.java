package lotto;

public class PriceValidation {

    public PriceValidation(int total_lotto_price) {
        price_validate(total_lotto_price);
    }


    private void price_validate(int price) {
        if( price % 1000 == 0 ) {
            throw new IllegalArgumentException("[Error] 로또 금액을 1000원 단위로 입력해야 합니다.");
        }
    }
}
