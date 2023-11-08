package lotto.util;

import lotto.domain.lottoresult.LottoResult;

public class LottoResultProvider {
    private static int INDEX = 0;

    public static LottoResult getLottoResult() {
        return LottoResult.getSomeLottoResult(INDEX++);
    }

    public static boolean isLottoResultRemain() {
        if (INDEX == LottoResult.getSizeOfLottoResult()) {
            resetIndex();
            return false;
        }
        return true;
    }

    private static void resetIndex() {
        INDEX = 0;
    }
}
