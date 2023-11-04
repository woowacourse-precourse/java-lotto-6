package lotto.model;

import lotto.model.lotto.LottoResult;

public class Person {
    private PaperBag paperBag;
    private LottoResult lottoResult;
    private final int purchaseAmout;


    private Person(int purchaseAmout) {
        this.purchaseAmout = purchaseAmout;
    }

    public static Person of(int purchaceAmout) {
        return new Person(purchaceAmout);
    }

    private void buyLotto(PaperBag paperBag) {
        this.paperBag = paperBag;
    }

    public PaperBag getPaperBag() {
        return paperBag;
    }


}