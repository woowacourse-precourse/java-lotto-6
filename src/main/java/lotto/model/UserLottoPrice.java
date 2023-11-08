package lotto.model;

public class UserLottoPrice {
    private static final String BUY_PRICE_ERROR = "[ERROR] 금액은 1000원 단위로 입력해주세요";
    private static final int LOTTO_ONE_PRICE = 1000;
    private int price;
    private int lottoAmount;
    private UserLottoUtil userLottoUtil = new UserLottoUtil();

    public UserLottoPrice(String buyPrice) {
        setPrice(buyPrice);
        validateUserPriceLotto(price);
        setLottoAmount(price);
    }

    public void setPrice(String buyPrice) {
        price = userLottoUtil.validateNumber(buyPrice);
    }

    public void setLottoAmount(int price) {
        lottoAmount = price / LOTTO_ONE_PRICE;
    }

    public int getPrice() {
        return price;
    }

    public int getLottoAmount() {
        return lottoAmount;
    }

    private void validateUserPriceLotto(int buyPrice) {
        if (buyPrice % LOTTO_ONE_PRICE != 0) {
            throw new IllegalArgumentException(BUY_PRICE_ERROR);
        }
    }

}
