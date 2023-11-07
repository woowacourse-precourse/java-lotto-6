package lotto.service;

public class ValidateService {

    private final Integer LOTTO_PRICE_FOR_ONE = 1000;


    public int validateBuyLottoInput(String buyPriceInput) {
        int buyPrice = parseIntPrice(buyPriceInput);
        isMultipliesOf1000(buyPrice);
        return buyPrice;
    }

    private int parseIntPrice(String buyPriceInput) {
        int buyPrice;
        try {
            buyPrice = Integer.parseInt(buyPriceInput);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("로또 구입 금액은 정수여야 합니다.");
        }
        return buyPrice;
    }

    private void isMultipliesOf1000(int buyPrice) {
        if (buyPrice % LOTTO_PRICE_FOR_ONE != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 1,000원 단위어야 합니다.");
        }
    }
}
