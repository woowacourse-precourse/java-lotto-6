package lotto.model;

import lotto.validation.ErrorMessage;

import static lotto.model.constant.LottoConstant.LOTTO_MIN_PRICE;

public class LottoPrice {

    private final int lottoPrice;

    public LottoPrice(int lottoPrice) {
        validateMinPrice(lottoPrice);
        validatePrice(lottoPrice);
        this.lottoPrice = lottoPrice;
    }

    public static void validateMinPrice(int lottoPrice) {
        if(lottoPrice < LOTTO_MIN_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_MIN_PRICE_ERROR.getMessage());
        }
    }

    public static void validatePrice(int lottoPrice) {
        if(lottoPrice%LOTTO_MIN_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_PRICE_ERROR.getMessage());
        }
    }

    public int getLottoPrice() {
        return lottoPrice;
    }

}
