package lotto.model;

import lotto.model.lotto.Lotto;

import java.util.List;

public class PaperBag {
    private final List<Lotto> lottoes;

    private PaperBag(List<Lotto> lottoes){
        this.lottoes = lottoes;
    }

    public static PaperBag of(List<Lotto> lottoes) {
        return new PaperBag(lottoes);
    }

    public List<Lotto> getLottoes() {
        return lottoes;
    }

}
