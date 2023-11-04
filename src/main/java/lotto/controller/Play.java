package lotto.controller;

public class Play {

    private static final int lottoPrice = 1000;
    public static int calLottoCount(int price) {
        return price / lottoPrice;
    }
}
