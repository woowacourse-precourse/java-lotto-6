package lotto.model;

import lotto.model.lotto.LottoHandler;

import java.util.List;

public class Person {
    private PaperBag paperBag;
    private final int purchaseAmout;


    private Person(int purchaseAmout) {
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


}