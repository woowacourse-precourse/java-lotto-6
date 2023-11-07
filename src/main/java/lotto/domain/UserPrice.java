package lotto.domain;


public class UserPrice {

    private final int price;

    public UserPrice(int price) {
        this.price = price;
    }

    public int buyCount(int lottoPrice) {
        return price / lottoPrice;
    }

    public Lotties buy(int lottoPrice){
        int lottoCnt = price / lottoPrice;
        return LottoFactory.generateLotties(lottoCnt);
    }

    public int getPrice() {
        return price;
    }
}
