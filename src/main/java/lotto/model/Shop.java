package lotto.model;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private final int purchaseAmount;
    private final int purchaseNumber;

    private Shop(int purchaseAmount) {
        isPurchaseAmountValid(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.purchaseNumber = purchaseAmount / 1000;
    }

    private void isPurchaseAmountValid(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000 단위의 숫자여야 합니다.");
        }
    }

    public int getPurchaseNumber() {
        return purchaseNumber;
    }

    public static Shop of(int purchaseAmount) {
        return new Shop(purchaseAmount);
    }

    public PaperBag giveLottoes() {
        List<Lotto> lottoes = new ArrayList<>();
        for (int i = 0; i < purchaseNumber; i++) {
            LottoGenerator lottoGenerator = new LottoGenerator();
            lottoes.add(lottoGenerator.getLotto());
        }
        return PaperBag.of(lottoes);
    }
}
