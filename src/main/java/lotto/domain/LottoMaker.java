package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.RandomNumbersGenerator;

public class LottoMaker {
    private static final int LOTTO_PRICE = 1000;
    private static final RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator();

    public static List<Lotto> makeLottoList(long purchaseAmount) {
        List<Lotto> lottoList = new ArrayList<>();
        int lottoCount = getLottoCount(purchaseAmount);
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(new Lotto(randomNumbersGenerator.randomNumbersGenerate()));
        }
        return lottoList;
    }

    private static int getLottoCount(long purchaseAmount) {
        return (int) (purchaseAmount / LOTTO_PRICE);
    }
}
