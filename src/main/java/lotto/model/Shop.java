package lotto.model;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoGenerator;
import lotto.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private final int purchaseAmount;
    private final int purchaseNumber;
    private final PaperBag paperBag;
    private static final Log log = new Log();

    private Shop(int purchaseAmount) {
        isPurchaseAmountValid(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.purchaseNumber = purchaseAmount / 1000;
        this.paperBag = wrapPaperBag();
    }

    private void isPurchaseAmountValid(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            log.error("1000 단위의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public int getPurchaseNumber() {
        return purchaseNumber;
    }

    public static Shop of(int purchaseAmount) {
        return new Shop(purchaseAmount);
    }

    public PaperBag givePaperBag() {
        return paperBag;
    }

    private PaperBag wrapPaperBag(){
        List<Lotto> lottoes = new ArrayList<>();
        for (int i = 0; i < purchaseNumber; i++) {
            Lotto lotto = LottoGenerator.generateLotto();
            lottoes.add(lotto);
        }
        return PaperBag.of(lottoes);
    }
}
