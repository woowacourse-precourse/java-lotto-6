package lotto.util;

public class MakeLottoCount {
    private static final int lottoPrice = 1000;

    public static int getLottoCount(int purchaseCount) {
        int lottoCount = purchaseCount / lottoPrice;
        return lottoCount;
    }
}
