package lotto.model;

import lotto.util.Log;

public class Person {
    private PaperBag paperBag;
    private final int purchaseAmout;
    private static final Log log = new Log();

    private Person(int purchaseAmout) {
        isDivisionOk(purchaseAmout);
        this.purchaseAmout = purchaseAmout;
    }

    public static Person of(int purchaceAmout) {
        return new Person(purchaceAmout);
    }

    public void buyLotto(PaperBag paperBag) {
        this.paperBag = paperBag;
    }

    public PaperBag getPaperBag() {
        return paperBag;
    }

    public String getLottoesToString() {
        return paperBag.lottoesToString();
    }

    public int getPurchaseAmout() {
        return purchaseAmout;
    }

    private void isDivisionOk(int input) {
        if (input % 1000 != 0) {
            log.error("1000 단위의 숫자여야 합니다.");
            throw new NumberFormatException();
        }
    }
}