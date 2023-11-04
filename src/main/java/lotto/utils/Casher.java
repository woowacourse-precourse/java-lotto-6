package lotto.utils;

public class Casher {
    private final int LOTTO_PRICE = 1000;
    private final String NOT_ENOUGH_PRICE = "금액이 부족합니다. 최소금액 : ";
    private final String NOT_LOTTO_UNIT = "로또 금액 단위로 입력해야 합니다. 입력단위 : ";

    public int getLottoCount(int price) {
        int lottoCount = price % LOTTO_PRICE;

        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException(NOT_ENOUGH_PRICE + LOTTO_PRICE);
        }
        if (lottoCount != 0) {
            throw new IllegalArgumentException(NOT_LOTTO_UNIT + LOTTO_PRICE);
        }
        return lottoCount;
    }
}
