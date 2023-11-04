package lotto;

public class Validation {
    private Validation() {};

    public static int getLottoPrice(String userInputLottoPrice) {
        try {
            int lottoPrice = Integer.parseInt(userInputLottoPrice);
            validateLottoPrice(lottoPrice);
            return lottoPrice;
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 유효한 숫자여야 합니다. (숫자 범위: 1,000 ~ 2,147,483,000)", ne);
        }
    }

    private static void validateLottoPrice(int lottoPrice) {
        if (lottoPrice < Constant.PRICE_UNIT_OF_LOTTO) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
        }
        if (lottoPrice % Constant.PRICE_UNIT_OF_LOTTO != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000으로 나누어 떨어져야 합니다.");
        }
    }
}
